package lambda;/**
 * Created by shenwei on 2017/3/3.
 */

import Entity.Person;
import common.PrintUtil;

import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-03-03
 */
public class OptionalTest {
    public static void main(String[] args){
        Optional<Person> optional=Optional.of(new Person("Jason","male"));
        optional.ifPresent(x->x.setName("Jane"));
        PrintUtil.printInfo(optional.get());

        Person person=null;
        Optional<Person> optional1=optional.ofNullable(null);
        optional.ifPresent(x->x.setName("testNull"));
        System.out.println(optional.get());
    }
}
