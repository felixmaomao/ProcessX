package io;/**
 * Created by shenwei on 2017/2/24.
 */

import Entity.Person;
import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class IoTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setSex("male");
        person.setName("shenwei");
        PrintUtil.printInfo(person);
    }
}
