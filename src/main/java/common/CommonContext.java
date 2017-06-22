package common; /**
 * Created by shenwei on 2017/2/24.
 */

import Entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class CommonContext {

    public static List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("shenwei", "1.06", 30000));
        personList.add(new Person("zhangxiaomao", "1.56", 20000));
        personList.add(new Person("linyi", "3.57", 20000));
        personList.add(new Person("jiahao", null, 15000));
        personList.add(new Person("max", "2.00", 30000));
        personList.add(new Person("jason", "1.55", 40000));
        personList.add(new Person("felix", "4.098", null));
        return personList;
    }

    public static Person getDefaultPerson() {
        return Person.DEFAULT_PERSON;
    }

    public static List<String> getStrings() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("C#");
        stringList.add("C");
        stringList.add("C++");
        stringList.add("Python");
        stringList.add("Scala");
        return stringList;
    }

}
