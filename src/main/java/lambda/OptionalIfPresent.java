package lambda;/**
 * Created by shenwei on 2017/6/7.
 */

import common.CommonContext;
import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-06-07
 */
public class OptionalIfPresent {
    public static void main(String[] args) {
        CommonContext.getPersons().stream().filter(x -> x.getName().equals("felix")).findFirst().ifPresent(y -> PrintUtil.printInfo(y));
    }
}
