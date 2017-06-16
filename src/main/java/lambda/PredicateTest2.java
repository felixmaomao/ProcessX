package lambda;/**
 * Created by shenwei on 2017/2/24.
 */

import Entity.Person;
import collection.ListFilter;
import common.CommonContext;
import common.PrintUtil;

import java.util.List;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        List<Person> personList = CommonContext.getPersons();
        List<Person> females = PersonFilter.filter(p -> p.getSex() == "female", personList);
        List<Person> males = PersonFilter.filter(p -> p.getSex() == "male", personList);
        List<Person> highSalarys = PersonFilter.filter(p -> p.getSalary() > 20000, personList);
        List<Person> middleSalarys = ListFilter.filter(p -> p.getSalary() > 10000 && p.getSalary() <= 20000, personList);
        List<String> stringList = ListFilter.filter(s -> s.startsWith("J"), CommonContext.getStrings());
        PrintUtil.printInfo(females);
        PrintUtil.printInfo(males);
        PrintUtil.printInfo(highSalarys);
        PrintUtil.printInfo(stringList);
    }
}
