package lambda;/**
 * Created by shenwei on 2017/6/6.
 */

import Entity.Person;
import common.PrintUtil;

import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-06-06
 */
public class OptionalChain {
    public static void main(String[] args) {
        //optional null安全链式操作
        Person person = new Person();
        person.setName("Felix");
        person.setSex(null);
        person.setSalary(300000);

        //错误写法 链式写法是不可以跳跃的 否则会出现空指针
        //String foo = Optional.ofNullable(person).map(x -> x.getSex().toUpperCase()).orElse("NONE");

        //正确写法 安全链式造作的关键在于向后 map
        String foo = Optional.ofNullable(person).map(x -> x.getSex()).map(x -> x.toUpperCase()).orElse("NONE");
        PrintUtil.printInfo(foo);
    }
}
