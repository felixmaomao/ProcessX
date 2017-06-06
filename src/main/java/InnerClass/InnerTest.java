package InnerClass;/**
 * Created by shenwei on 2017/2/24.
 */

import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-02-24
 * i think that inner class is bowl of shit
 */
public class InnerTest {
    public static void main(String[] args) {
        new Outer().getInnerInstance().readLable();
    }
}

class Outer {
    class Inner {
        private String lable = "hello outer world";

        public void readLable() {
            PrintUtil.printInfo(lable);
        }
    }

    public Inner getInnerInstance() {
        return new Inner();
    }
}
