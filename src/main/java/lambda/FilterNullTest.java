package lambda;/**
 * Created by shenwei on 2017/5/18.
 */

import common.PrintUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shenwei
 * @create 2017-05-18
 */
public class FilterNullTest {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("xx", "yy", null, "zz", "qq");
        //还是需要做空判断的
        List<String> filterStrs = strs.stream().filter(x -> x != null && x.contains("x")).collect(Collectors.toList());
        PrintUtil.printInfo(filterStrs);
    }
}
