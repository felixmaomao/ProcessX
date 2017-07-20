package string;/**
 * Created by shenwei on 2017/5/16.
 */

/**
 * @author shenwei
 * @create 2017-05-16
 */
public class StringSplitTest {
    public static void main(String[] args) {
        String str = "zzzzzzzzzzz";
        System.out.println(str.split("A").length);
        System.out.println(str.split("-")[0]);
    }
}
