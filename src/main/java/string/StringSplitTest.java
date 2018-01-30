package string;/**
 * Created by shenwei on 2017/5/16.
 */

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
    }
}
