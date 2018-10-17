package string;/**
 * Created by shenwei on 2017/5/16.
 */

import date.DateUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * @author shenwei
 * @create 2017-05-16
 */
public class StringSplitTest {
    public static void main(String[] args) {
        String str = "zzzzzzzzzzz";
        System.out.println(str.split("\\^").length);
        System.out.println(str.split("-")[0]);

        System.out.println("33".replace("3", "胜"));

        System.out.println(Arrays.stream("33".split("")).reduce((r1, r2) -> r1 + ":" + r2).get());

        System.out.println(StringUtils.isEmpty(""));

        String sessionUrl="https://zoom.us/j/123321?test";
        String browser="epic";
        sessionUrl= sessionUrl + "?browser=" + browser;
        System.out.println(sessionUrl);

        System.out.println("111");
        System.out.println(sessionUrl.contains("?"));

        System.out.println("mydomain.com".split(",")[0]);
    }
}
