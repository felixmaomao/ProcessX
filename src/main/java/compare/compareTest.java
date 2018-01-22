package compare;/**
 * Created by shenwei on 2018/1/18.
 */

import common.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shenwei
 * @create 2018-01-18
 * 由小往大排,想排在前面 就让compare 结果小于0
 */
public class compareTest {
    public static void main(String[] args) {
        List list = Arrays.asList(10, 4, 89, 12);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        PrintUtil.printInfo(list);
    }
}
