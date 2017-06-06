package common;/**
 * Created by shenwei on 2017/2/24.
 */

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author shenwei
 * @create 2017-02-24
 */
public class PrintUtil {
    /**
     * @Author shenwei
     * @Date 2017/2/24 18:33
     * @Description 输出对象所有字段信息
     */
    public static <T> void printInfo(T t) {
        try {
            Class<?> c = t.getClass();
            //String 类型则直接输出
            if (c == String.class) {
                System.out.println(t);
                return;
            }
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.toString().substring(field.toString().lastIndexOf(".") + 1);
                System.out.println(fieldName + "--->" + field.get(t));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author shenwei
     * @Date 2017/2/24 18:34
     * @Description 输出list所有对象字段信息
     */
    public static <T> void printInfo(List<T> list) {
        if (list != null && list.size() > 0) {
            System.out.println("---------------------");
            for (T t : list) {
                printInfo(t);
            }
        }
    }
}
