package lambda;/**
 * Created by shenwei on 2017/6/15.
 */

import entity.Person;

import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-06-15
 */
public class OptionalOfNullable {
    public static void main(String[] args) {
        Person person = null;
//
//        String name = Optional.ofNullable(person).orElse(Person.DEFAULT_PERSON).getName();
//        System.out.println("name:" + name);
//
//        // from person to name ,单在整个过渡当中，有很多地方可能产生null 这时候才用 ofNullable 结合 map一直链式下去就会很安全
//        //chain
//        String name1 = Optional.ofNullable(person).map(x -> x.getName()).orElse("nothing");
//        System.out.println("name1:" + name1);
//
//        //ifPresent
//        Optional.ofNullable(person).ifPresent(x -> System.out.println("name2" + Optional.ofNullable(x.getName()).orElse("nothing")));
//
//        String name3 = "";
//        //Optional.ofNullable(person).ifPresent(x -> name3 = x.getName());

        String temp=null;
        long va= Optional.ofNullable(temp).map(x->Long.valueOf(x)).orElse(new Long(0));
        System.out.print(va);

    }
}
