package primative;/**
 * Created by shenwei on 2017/6/16.
 */

/**
 * @author shenwei
 * @create 2017-06-16
 */
public class CompareToTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        System.out.println(a.compareTo(b));  //-1

        Integer c = 10;
        Integer d = 9;
        System.out.println(c.compareTo(d));  //1

        // 数字之间的compareTo 小于则返回-1  等于则返回0  大于则返回1
        // 字符串之间的比较, 则是从前向后，一个字符一个字符的比较，如果相等则比较后面的字母，否则直接返回比较结果
        
    }
}
