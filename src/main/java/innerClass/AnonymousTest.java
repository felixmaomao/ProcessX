package innerClass;/**
 * Created by shenwei on 2017/2/25.
 */

import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-02-25
 */
public class AnonymousTest {
    public static void main(String[] args){
         AnonymousTest anonymousTest=new AnonymousTest();
         anonymousTest.addListener(new Listener() {
             @Override
             public void doJob() {
                 PrintUtil.printInfo("jobs down");
             }
         });
    }

    public void addListener(Listener listener){
        listener.doJob();
    }
}
