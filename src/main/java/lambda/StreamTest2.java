package lambda;/**
 * Created by shenwei on 2017/5/12.
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author shenwei
 * @create 2017-05-12
 */
public class StreamTest2 {
    public static void main(String[] args){
        try (Stream<String> lines = Files.lines(Paths.get("F:\\Personal\\Processx\\src\\main\\java\\lambda\\data"))) {
            lines.forEach(System.out::println);
        }catch (Exception e){
             System.out.println(e.toString());
        }
    }
}
