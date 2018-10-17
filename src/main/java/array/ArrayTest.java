package array;

import date.DateUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        String[] params = new String[17];

            String[] columns = {"email", "first_name", "last_name", "address", "city", "country", "zip", "state", "phone", "industry",
                    "job_title", "no_of_employees", "org", "comments", "confirm_email", "purchasing_time_frame", "role_in_purchase_process"};



                    int idx = ArrayUtils.indexOf(columns, "comssjments");
        params[idx] = "xxx";
        System.out.println("xxxxxxxxxxxx");



    }
}
