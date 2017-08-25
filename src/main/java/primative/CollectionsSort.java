package primative;/**
 * Created by shenwei on 2017/6/16.
 */

import entity.Person;
import common.CommonContext;
import common.PrintUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-06-16
 */
public class CollectionsSort {
    public static void main(String[] args) {
        List<Person> persons = CommonContext.getPersons();

        //step1
        // 最老版的排序 是利用collections.sort 进行排序 第一个参数为待排序的集合 第二个则为一个comparator的子类 然后下面才用的是匿名类来实现的
//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return Optional.ofNullable(o1.getSalary()).orElse(0).compareTo(Optional.ofNullable(o2.getSalary()).orElse(0));
//            }
//        });
//        PrintUtil.printInfo(persons);

        //step2
        //稍微简洁一点的写法 但是这里必须指明类型 多条件排序
        //Collections.sort(persons, Comparator.comparing((Person x) -> Optional.ofNullable(x.getSalary()).orElse(0)).thenComparing((Person x) -> x.getName()));
        //这样子写则不行 让人费解 具体原因仍不知
        //Collections.sort(persons, Comparator.comparing(x -> Optional.ofNullable(x.getSalary()).orElse(0)).thenComparing(x -> x.getName()));
        //PrintUtil.printInfo(persons);
        //上面两种排完之后,list里面的数据就已经发生了变化

        //step3
        //List<Person> sortedPersons = persons.stream().sorted(Comparator.comparing((Person x) -> x.getSalary()).thenComparing((Person x) -> x.getName())).collect(Collectors.toList());
        //PrintUtil.printInfo(sortedPersons);

        //step4
        persons.sort(Comparator.comparing((Person x) -> Optional.ofNullable(x.getSex()).orElse("未知")).reversed());
        PrintUtil.printInfo(persons);
    }
}
