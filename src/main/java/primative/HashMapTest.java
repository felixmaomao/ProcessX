package primative;/**
 * Created by shenwei on 2017/12/26.
 */

import java.util.HashMap;

/**
 * @author shenwei
 * @create 2017-12-26
 */
public class HashMapTest {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("1", "xxx");

        map.entrySet().stream().forEach(x -> System.out.println(x.getValue()));
    }
}
