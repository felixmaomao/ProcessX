package lambda;/**
 * Created by shenwei on 2017/6/6.
 */

import entity.Person;
import common.CommonContext;
import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-06-06
 * optional为空设置默认值,这样有什么坏处呢 就是哪怕不为空 提供的方法也会执行一遍 orelseget 则不会
 */
public class OptionalOrElse {
    public static void main(String[] args) {
        // orElse 设置为空默认值
        Person person = CommonContext.getPersons().stream().filter(x -> x.getName().equals("Felix")).findFirst().orElse(Person.DEFAULT_PERSON);
        PrintUtil.printInfo(person);

        //既然只需要提供默认值,那通过一个方法来提供自然也是可以的 但是这种写法既是前面存在匹元素 OrElse中的方法依旧会执行,浪费性能
        Person person1 = CommonContext.getPersons().stream().filter(x -> x.getName().equals("felix")).findFirst().orElse(CommonContext.getDefaultPerson());
        PrintUtil.printInfo(person1);
    }
}
