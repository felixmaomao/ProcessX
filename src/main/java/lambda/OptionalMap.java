package lambda;/**
 * Created by shenwei on 2017/6/7.
 */

import common.PrintUtil;

import java.util.Optional;

/**
 * @author shenwei
 * @create 2017-06-07
 */
public class OptionalMap {
    public static void main(String[] args) {
        String str = Optional.of("little baby").map(x -> x.toUpperCase()).get();
        PrintUtil.printInfo(str);
    }
}
