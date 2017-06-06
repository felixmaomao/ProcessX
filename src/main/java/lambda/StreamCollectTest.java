package lambda;/**
 * Created by shenwei on 2017/5/16.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author shenwei
 * @create 2017-05-16
 */
public class StreamCollectTest {
    public static void main(String[] args){
        System.out.println(Arrays
                .asList("apple", "banana", "pear", "kiwi", "orange")
                .stream()
                .filter(s -> s.contains("12"))
                .collect(Collectors.toList())
        );
    }
}
