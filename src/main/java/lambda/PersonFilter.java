package lambda;/**
 * Created by shenwei on 2017/2/24.
 */

import entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class PersonFilter {
    public static List<Person> filter(Predicate<Person> predicate, List<Person> personList) {
        if (personList != null && personList.size() > 0) {
            List<Person> list = new ArrayList<>();
            for (Person person : personList) {
                if (predicate.test(person)) {
                    list.add(person);
                }
            }
            return list;
        }
        return personList;
    }
}
