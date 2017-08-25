package lambda;/**
 * Created by shenwei on 2017/2/25.
 */

import entity.Person;
import common.CommonContext;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author shenwei
 * @create 2017-02-25
 */
public class ConsumerTest {
    public static void main(String[] args) {
        makePeopleHappy(p -> System.out.println("sing a song"), CommonContext.getPersons());
    }

    public static void makePeopleHappy(Consumer consumer, List<Person> personList) {
        for (Person person : personList) {
            consumer.accept(person);
        }
    }
}
