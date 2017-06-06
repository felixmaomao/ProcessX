package md5;


import org.apache.commons.codec.digest.DigestUtils;


/**
 * @author shenwei
 * @create 2017-03-13
 */
public class MD5Utils {

    public static String encrypt(String input, String key) {
        return DigestUtils.md5Hex(input + key).toUpperCase();
    }

    public static String encrypt(String input) {
        return encrypt(input, "");
    }
}
