package lambda;/**
 * Created by shenwei on 2017/5/9.
 */

import entity.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenwei
 * @create 2017-05-09
 */
public class ComputeIfAbsentTest {
    private final Map<String, Person> allTwitterUsers = new HashMap<>();

    public void onMessage(String twitterHandle) {

    }


    public static void main(String[] args) {

    }
}
