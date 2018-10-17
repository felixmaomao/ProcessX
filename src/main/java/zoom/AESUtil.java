package zoom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class AESUtil {
    public static void main(String[] args) throws Exception {


        String data2 = "MEpCOXFDRlNQdWIlMkJRQmdueHE5TVlXYmRrQk1CaGJYdndqaVFFcnlWaENydEs1NkxMS1VaWUpjZ012V3dmJTJCWk9Pdkhobnk4ZEI4dDZOR0dUSzNEOTlJai9jR3BCMmN2VmZHeEhlTW45b0ZTWnN3dVBTTVBLa3RKdmlUcVhUWW1NZ3lLS2lHQnVuVE1QNWswOXNGdkhKQT09";
        byte[] keys = getkey("S4vuqWwgvW0Rr1ZvEaOBJPECiJJTFJgrJO0h");
        String ss = aesDecrypt(data2, keys);
        System.out.println(ss);


        //qxWBwXZKRteOHnS2nwzE7A       apikey
        //ep:  JVau36UegvmJNdRw0iUvQZ8yhIgCvjWGOLnK     apiSecret
        //qxWBwXZKRteOHnS2nwzE7A
        //dev:  lSmfesjOmSgL6vJSXcH6hv5AUxAx6diZHl2f
        //c0N2zyFTRKOcJK-_DgqprA
        //stage:  ZrA8TQlaO6HsodOB97bLQfxU46R9EQ1eKKp5
        String apiKey = "ujO1puuyQ8yLYnKl3wZPyQ";
        String apiSecret = "wPzal3zyXDvcmkasKNnmW5NGQRormYdq3QmF";
        String userId = "10D";
        String patientId = "15P";
        String patient2Id = "42P";
        //String sessionId = Integer.toString((new Random()).nextInt());
        String sessionId = "12324357657";
        byte[] key = getkey(apiSecret);

//        String data2="usertype=1&userid=FAMMD&sessionid=5067983&firstname=Physician&lastname=Family+Medicine&email=";
//        System.out.println(aesEncrypt(data2,key));

        String data = "usertype=1&userid=" + userId + "&sessionid=" + sessionId + "&firstname=felix10&lastname=doctor&email=felix.shen@zoom.us";

        //System.out.println(Arrays.toString(key));
        String encryptData = aesEncrypt(data, key);
        // String encryptData = "IeC7v+j4KAHJHt1ePwNaqg==";
        //String decrypData = aesDecrypt(encryptData, key);
        //System.out.println(encryptData);
        //System.out.println(decrypData);
        System.out.println(
                "https://dev.zoom.us/telehealth?org_id=" + apiKey + "&data=" + encryptData.replaceAll("\\+", "%2B"));
        System.out.println(data);
        //patient1
        data = "usertype=2&userid=" + patientId + "&sessionid=" + sessionId + "&firstname=Patient&lastname=No827";
        encryptData = aesEncrypt(data, key);
        System.out.println(
                "https://dev.zoom.us/telehealth?org_id=" + apiKey + "&data=" + encryptData.replaceAll("\\+", "%2B"));
        System.out.println(data);
        //patient2
        data = "usertype=2&userid=" + patient2Id + "&sessionid=" + sessionId + "&firstname=Patient2&lastname=No41";
        encryptData = aesEncrypt(data, key);
        System.out.println(
                "https://dev.zoom.us/telehealth?org_id=" + apiKey + "&data=" + encryptData.replaceAll("\\+", "%2B"));
        System.out.println(data);
        //getkey(apiSecret);
    }

    public static String aesEncrypt(String str, byte[] key) {
        if (str == null || key == null)
            return null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), iv);
            byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    public static String aesDecrypt(String str, byte[] key) {
        if (str == null || key == null)
            return null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), iv);
            byte[] bytes = Base64.decodeBase64(str);
            bytes = cipher.doFinal(bytes);
            return new String(bytes, "utf-8");
        } catch (Exception e) {
            //throw new ServiceException("AES decrypt failure");
            return null;
        }
    }

    public static byte[] getkey(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(key.getBytes("utf-8"));
        byte baseData[] = digest.digest();

        byte[] buffer1 = new byte[64];
        byte[] buffer2 = new byte[64];

        for (int i = 0; i < 64; i++) {
            buffer1[i] = 0x36;
            buffer2[i] = 0x5C;
            if (i < baseData.length) {
                buffer1[i] ^= baseData[i];
                buffer2[i] ^= baseData[i];
            }
        }
        digest.update(buffer1);
        byte[] buffer1Hash = digest.digest();
        digest.update(buffer2);
        byte[] buffer2Hash = digest.digest();
        byte[] both = Arrays.copyOfRange((byte[]) ArrayUtils.addAll(buffer1Hash, buffer2Hash), 0, 16);

        return both;

    }

    public static byte[] getkey2(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(key.getBytes("utf-8"));
       return digest.digest();

    }

}

