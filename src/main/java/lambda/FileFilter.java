package lambda;

import java.io.File;
import java.util.function.Predicate;

/**
 * Created by shenwei on 2017/2/27.
 */
@FunctionalInterface
public interface FileFilter {
    boolean filter(Predicate<File>[] predicates);
}
