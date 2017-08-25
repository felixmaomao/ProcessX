package lambda;/**
 * Created by shenwei on 2017/6/16.
 */

import entity.Person;
import common.CommonContext;
import common.PrintUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenwei
 * @create 2017-06-16
 */
public class SortComparing {
    public static void main(String[] args) {
        // java8 链式排序
        List<Person> sortedPersons = CommonContext.getPersons().stream().sorted(Comparator.comparing((Person x) -> x.getSalary()).thenComparing((Person x) -> x.getName())).collect(Collectors.toList());
        PrintUtil.printInfo(sortedPersons);
    }
}
