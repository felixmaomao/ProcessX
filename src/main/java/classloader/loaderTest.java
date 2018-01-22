package classloader;/**
 * Created by shenwei on 2018/1/22.
 */

import entity.Person;

/**
 * @author shenwei
 * @create 2018-01-22
 */
public class loaderTest {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            Class cls = loader.loadClass("entity.Person");
            Person person = (Person) cls.newInstance();
            System.out.println("xx");
        } catch (Exception e) {

        }

    }
}
