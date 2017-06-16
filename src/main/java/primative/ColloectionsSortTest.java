package primative;/**
 * Created by shenwei on 2017/6/16.
 */

import Entity.Person;
import common.CommonContext;
import common.PrintUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-06-16
 */
public class ColloectionsSortTest {
    public static void main(String[] args) {
        List<Person> persons = CommonContext.getPersons();

        // 最老版的排序 是利用collections.sort 进行排序 第一个参数为待排序的集合 第二个则为一个comparator的子类 然后下面才用的是匿名类来实现的
//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return Optional.ofNullable(o1.getSalary()).orElse(0).compareTo(Optional.ofNullable(o2.getSalary()).orElse(0));
//            }
//        });
//        PrintUtil.printInfo(persons);

        //稍微简洁一点的写法
        Collections.sort(persons, Comparator.comparing(x -> Optional.ofNullable(x.getSalary()).orElse(0)));
        PrintUtil.printInfo(persons);
    }
}
