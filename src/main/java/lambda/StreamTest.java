package lambda;/**
 * Created by shenwei on 2017/5/9.
 */

import Entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author shenwei
 * @create 2017-05-09
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        fruitStream.filter(x -> x.contains("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
