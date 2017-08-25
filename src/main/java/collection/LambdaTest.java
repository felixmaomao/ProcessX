package collection;/**
 * Created by shenwei on 2017/3/21.
 */

import entity.Person;
import common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenwei
 * @create 2017-03-21
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jason", "male"));
        personList.add(new Person("Jane", "female"));
        personList.add(new Person("Simon", "male"));
        PrintUtil.printInfo(ListUtil.filter(x -> x.getName().equals("xxx") || x.getName().equals("Simon"), personList));
    }
}
