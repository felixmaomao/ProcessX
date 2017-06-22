package string;/**
 * Created by shenwei on 2017/6/21.
 */

/**
 * @author shenwei
 * @create 2017-06-21
 */
public class StringFormat {
    public static void main(String[] args) {
        String a = String.format("order:scheme:%s", new Long(100));
        System.out.println(a);
    }
}
