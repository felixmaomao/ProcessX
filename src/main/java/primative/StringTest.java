package primative;/**
 * Created by shenwei on 2017/2/23.
 */

import Entity.Person;

/**
 * @author shenwei
 * @create 2017-02-23
 */
public class StringTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("shenwei");
        person.setSex("male");
        toStringTest(person);
    }

    public static <T> void toStringTest(T t) {
        System.out.println(t);
        System.out.println("hashcode:" + t.hashCode());
    }

}



