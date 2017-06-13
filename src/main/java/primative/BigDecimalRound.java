package primative;/**
 * Created by shenwei on 2017/6/12.
 */

import java.math.BigDecimal;

/**
 * @author shenwei
 * @create 2017-06-12
 */
public class BigDecimalRound {
    public static void main(String[] args) {
        String str = "3.141592653";
        System.out.println(BigDecimal.valueOf(Double.valueOf(str)).setScale(2,BigDecimal.ROUND_FLOOR).toString());
    }
}
