package file;/**
 * Created by shenwei on 2018/1/25.
 */

import java.io.File;

/**
 * @author shenwei
 * @create 2018-01-25
 */
public class fileTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File bootstrapJar = new File(System.getProperty("user.dir"), "bootstrap.jar");
        if (bootstrapJar.exists()) {
            System.out.println("file exists");
        } else {
            System.out.println("NO file exists");
        }
    }
}
