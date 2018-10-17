package zoom;

import json.Jackson2Util;
import network.HttpRequestUtil;
import okhttp3.*;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketoIssueTracking {

    public static String clientId = "9c2aacbe-cdee-404b-9d7a-11199663c77c";
    public static String clientSecret = "Kyxh0KLEdvZjYZytAqoJ9hQyPOXmxU5b";
    public static String endPoint = "https://702-NTK-721.mktorest.com";
    public static Integer attendeesCampaignId = 1873;
    public static String attendeesReportFilePath = "D://913843561AttendeeReport.csv";

    public static void main(String[] args) {
        try {
            // must replace the parameters upside
            pushAttendeesToMarketoMannually();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getAccessToken() throws Exception {
        System.out.println("--get marketo access token--");
        String url = endPoint + "/identity/oauth/token?grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;
        System.out.println("token url: " + url);
        String token = "token null";
        int expires = 0;
        HttpRequestUtil httpRequest = HttpRequestUtil.get(url);
        httpRequest.accept("application/json");
        int responseCode = httpRequest.code();
        if (responseCode == 200) {
            String respBody = httpRequest.body();
            HashMap resp = Jackson2Util.fromJson(respBody, HashMap.class);
            token = (String) resp.get("access_token");
            System.out.println("access_token: " + token);
        }
        return token;
    }

    //step 1: get leads json from attendees report excel
    public static String getExcelLeadJson(String filePath) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String line = null;
        List<Map<String, String>> leads = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String item[] = line.split(",");
            HashMap map = new HashMap();
            map.put("firstName", item[0]);
            map.put("lastName", item[1]);
            map.put("email", item[2]);
            //if (item.length > 3) {
            map.put("country", item[3]);
            //}
            leads.add(map);
        }
        String leadsJson = getLeadsJson(leads);
        System.out.println("--get leadsJson from excel success,leadsJson:" + leadsJson);
        return leadsJson;
    }

    public static String pushLeadsToMarketo(String filePath, String accessToken) throws Exception {
        String leadsUrl = endPoint + "/rest/v1/leads.json?access_token=" + accessToken;
        System.out.println("--push leads to marketo leads url:" + leadsUrl);
        String leadsJson = getExcelLeadJson(filePath);
        if (StringUtils.isNotEmpty(leadsJson)) {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, leadsJson);
            Request request = new Request.Builder()
                    .url(leadsUrl)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    //.addHeader("Postman-Token", "d1c06b06-a8b4-44dd-9d9a-3b99b7d362c1")
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                String resp = response.body().string();
                System.out.println("---marketo returned leadsJson:" + resp);
                return resp;
            } else {
                System.out.println("error pushing leads to marketo");
                return null;
            }
        } else {
            System.out.println("leadsJson from excel is empty!");
            return null;
        }
    }

    public static void requestMarketoCampaign(Integer campaignId, String campaignLeadJson, String accessToken) throws Exception {
        if (StringUtils.isNotEmpty(campaignLeadJson)) {
            String url = endPoint + "/rest/v1/campaigns/" + campaignId + "/trigger.json?access_token=" + accessToken;
            System.out.println("--request marketo campaign url:" + url);
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, campaignLeadJson);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Cache-Control", "no-cache")
                    //.addHeader("Postman-Token", "22db98ef-7d1a-47ee-b29d-b743325ddc8e")
                    .build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                System.out.println("---request marketo campaign success:" + response.body());
            } else {
                System.out.println("request marketo campaign failed");
            }
        }
    }

    private static String getLeadsJson(List<Map<String, String>> leads) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("action", "createOrUpdate");
        map.put("input", leads);
        String json = null;
        try {
            json = Jackson2Util.toJson(map);
        } catch (IOException e) {
            System.out.println("Create Marketo lead json error:" + e.toString());
        }
        return json;
    }


    public static void pushAttendeesToMarketoMannually() throws Exception {
        String accessToken = getAccessToken();
        String marketoReturnedLeadsJson = pushLeadsToMarketo(attendeesReportFilePath, accessToken);
        String campaignLeadJson = getCampaignRequestJson(marketoReturnedLeadsJson);
        requestMarketoCampaign(attendeesCampaignId, campaignLeadJson, accessToken);
    }

    //step2 get campaign request json
    public static String getCampaignRequestJson(String json) throws Exception {
        HashMap resp = Jackson2Util.fromJson(json, HashMap.class);
        Boolean success = (Boolean) resp.get("success");
        if (success) {
            String requestCampaignLeadsJson = getRequestCampaignJson(resp);
            System.out.println("---request campaign leads json: " + requestCampaignLeadsJson);
            return requestCampaignLeadsJson;
        } else {
            System.out.println("campaign request leads json format failed");
            return null;
        }
    }

    private static String getRequestCampaignJson(HashMap respData) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, List> leadsMap = new HashMap<String, List>();
        List<Map<String, String>> leads = new ArrayList<Map<String, String>>();
        List<Map> respList = (List<Map>) respData.get("result");
        if (respList != null && !respList.isEmpty()) {
            for (Map respMap : respList) {
                if (respMap != null && respMap.get("id") != null) {
                    String id = Integer.toString((Integer) respMap.get("id"));
                    Map<String, String> lead = new HashMap<String, String>();
                    lead.put("id", id);
                    leads.add(lead);
                }
            }
        }
        leadsMap.put("leads", leads);
        resultMap.put("input", leadsMap);
        String json = null;
        try {
            json = Jackson2Util.toJson(resultMap);
        } catch (IOException e) {
            System.out.println("Marketo request campaign json data error :" + e.getMessage());
        }
        return json;
    }

}
