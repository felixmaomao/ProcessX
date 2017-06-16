package lambda;/**
 * Created by shenwei on 2017/2/24.
 */

import Entity.Person;
import common.CommonContext;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class PredicateTest {


    public static void main(String[] args) {
        List<Person> personList = CommonContext.getPersons();
        for (Person person : personList) {
            System.out.println("name" + person.getName() + "sex:" + person.getSex());
            NotSureToSayHi((Person p) -> p.getSex() == "female", person);
        }
    }

    public static void NotSureToSayHi(Predicate<Person> predicate, Person person) {
        if (predicate.test(person)) {
            System.out.println("yeah you are female ,i will say hi to you!");
        } else {
            System.out.println("sorry you are male , i will not say hi to you!");
        }
    }
}
