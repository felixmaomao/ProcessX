package lambda;/**
 * Created by shenwei on 2017/6/15.
 */

import entity.Person;
import common.CommonContext;
import common.PrintUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author shenwei
 * @create 2017-06-15
 */
public class FilterTest {
    public static void main(String[] args) {
        List<Person> personList = CommonContext.getPersons();
        //当集合里有元素的sex为null的时候,下面的仍会报空指针的
        //List<Person> malePersons = personList.stream().filter(x -> x.getSex().equals("male")).collect(Collectors.toList());
        List<Person> malePersons = personList.stream().filter(x -> Optional.ofNullable(x.getSex()).orElse("no").equals("male")).collect(Collectors.toList());
        PrintUtil.printInfo(malePersons);
    }
}
