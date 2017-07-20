package reflection;/**
 * Created by shenwei on 2017/7/20.
 */

import Entity.Person;

/**
 * @author shenwei
 * @create 2017-07-20
 */
public class classLoaderTest {
    public static void main(String[] args) {
        Person person = new Person();
        ClassLoader classLoader = person.getClass().getClassLoader();
        System.out.println(classLoader.toString());
    }
}
