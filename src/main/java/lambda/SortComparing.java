package lambda;/**
 * Created by shenwei on 2017/6/16.
 */

import Entity.Person;
import common.CommonContext;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenwei
 * @create 2017-06-16
 */
public class SortComparing {
    public static void main(String[] args) {
        List<Person> sortedPersons = CommonContext.getPersons().stream().sorted(Comparator.comparing(x -> x.getSex())).collect(Collectors.toList());

    }
}
