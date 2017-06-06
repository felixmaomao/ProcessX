package collection;/**
 * Created by shenwei on 2017/2/25.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author shenwei
 * @create 2017-02-25
 */
public class ListFilter {

    /**
     * @Author shenwei
     * @Date 2017/2/25 10:58
     * @Description filter things that maps our condition
    */
    public static <T> List<T> filter(Predicate<T> predicate, List<T> sourceList) {
        if (sourceList != null && sourceList.size() > 0) {
            List<T> destinationList = new ArrayList<T>();
            for (T item : sourceList) {
                if (predicate.test(item)) {
                    destinationList.add(item);
                }
            }
            return destinationList;
        }
        return sourceList;
    }
}
