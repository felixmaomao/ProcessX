package primative;/**
 * Created by shenwei on 2017/7/31.
 */

import org.apache.commons.lang.StringUtils;

/**
 * @author shenwei
 * @create 2017-07-31
 */
public class StringNullTest {
    public static void main(String[] args) {
        String temp = null;
        //并不会报null
        if (temp != "aaa" && StringUtils.isNotBlank(temp)) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
