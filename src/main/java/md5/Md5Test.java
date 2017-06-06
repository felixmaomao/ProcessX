package md5;/**
 * Created by shenwei on 2017/3/30.
 */

import common.PrintUtil;

/**
 * @author shenwei
 * @create 2017-03-30
 */
public class Md5Test {
    public final static String MD5Key = "Q56GtyNkop97H334TtyturfgErvvv98r";

    public static void main(String[] args) {
        String str = "pdl80!QQ";
        PrintUtil.printInfo(MD5Utils.encrypt(str, MD5Key));

    }
}
