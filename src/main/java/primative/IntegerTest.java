package primative;/**
 * Created by shenwei on 2017/2/23.
 */

/**
 * @author shenwei
 * @create 2017-02-23
 */
public class IntegerTest {
    public static void main(String[] args) {
        //偶数而言
        Integer num1 = 6;
        //左移
        num1 = num1 << 1;
        printBytes(num1);
        //右移
        num1 = num1 >> 1;
        printBytes(num1);

        //奇数而言
        Integer num2 = 7;
        num2 = num2 >> 1;  //自动取整了
        printBytes(num2);
        num2 = num2 << 1;
        printBytes(num2);
    }

    public static void printBytes(Integer num) {
        System.out.println("num:" + num + "  bytes:" + Integer.toBinaryString(num));
    }
}
