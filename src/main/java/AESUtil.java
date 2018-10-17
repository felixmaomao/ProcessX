import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AESUtil {
    public static void main(String[] args) throws Exception {

        String userId = "1027D";
        String patientId = "1024P";
        String sessionId = "20181011";
        String apiKey = "ujO1puuyQ8yLYnKl3wZPyQ";
        String apiSecret = "wPzal3zyXDvcmkasKNnmW5NGQRormYdq3QmF";
        byte[] key = getkey(apiSecret);

        // doctor
        String data = "usertype=1&userid=" + userId + "&sessionid=" + sessionId + "&firstname=felix&lastname=mydoctor&email=felix.mao@zoom.us";
        String encryptData = aesEncrypt(data, key);
        System.out.println("https://dev.zoom.us/telehealth?org_id=" + apiKey + "&data=" + encryptData.replaceAll("\\+", "%2B"));

        //patient1
        data = "usertype=2&userid=" + patientId + "&sessionid=" + sessionId + "&firstname=Patient&lastname=12";
        encryptData = aesEncrypt(data, key);
        System.out.println("https://dev.zoom.us/telehealth?org_id=" + apiKey + "&data=" + encryptData.replaceAll("\\+", "%2B"));

        System.out.println(aesDecrypt(encryptData, key));

        System.out.println("1024D@zoomtelevisit.hello.edu".replaceAll("@zoomtelevisit.com", ""));
    }

    public static String aesEncrypt(String str, byte[] key) throws Exception {
        if (str == null || key == null)
            return null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), iv);
            byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
            return Base64.encodeBase64String(bytes);
        } catch (Exception e) {
            throw new Exception("AES decrypt failure");
        }
    }

    public static String aesDecrypt(String str, byte[] key) throws Exception {
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
            throw new Exception("AES decrypt failure");
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
}

