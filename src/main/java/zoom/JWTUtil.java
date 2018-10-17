package zoom;

import java.util.Date;

import com.auth0.jwt3.JWT;
import com.auth0.jwt3.algorithms.Algorithm;

public class JWTUtil {
    public static void main(String[] args) {
        System.out.println(createAPIToken("ujO1puuyQ8yLYnKl3wZPyQ", "wPzal3zyXDvcmkasKNnmW5NGQRormYdq3QmF"));
    }

    public static String createAPIToken(String apiKey, String apiSecret) {
        String jwt = "";
        try {
            // expire time
            long expMillis = System.currentTimeMillis() + 7200 * 1000L; // two hours
            System.out.println(expMillis);
            Date exp = new Date(expMillis);

            jwt = JWT.create()
                    .withIssuer(apiKey)
                    .withExpiresAt(exp)
                    .sign(Algorithm.HMAC256(apiSecret));
        } catch (Exception e) {
            return jwt;
        }

        return jwt;
    }
}
