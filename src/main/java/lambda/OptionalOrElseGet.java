package lambda;/**
 * Created by shenwei on 2017/6/7.
 */

import Entity.Person;
import common.CommonContext;
import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-06-07
 * lazily provide a default value using a supplier
 */
public class OptionalOrElseGet {
    public static void main(String[] args) {
        // OrElseGet相比OrElse的优越之处在于 如果前面匹配到元素 则后面的方法就不会执行 不会浪费性能
        Person person = CommonContext.getPersons().stream().filter(x -> x.getName().equals("telix")).findFirst().orElseGet(() -> CommonContext.getDefaultPerson());
        PrintUtil.printInfo(person);
    }
}
