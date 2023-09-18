package src.main;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SecretKeyGenerator {
    public static BigInteger generate(int n) {
        SecureRandom random = new SecureRandom();
        BigInteger key;
        while (true) {
            
            byte[] keyBytes = new byte[32];
            random.nextBytes(keyBytes);
            key = new BigInteger(1, keyBytes);
            if (Utils.lessThan(BigInteger.valueOf(1), key) && Utils.lessThan(key, BigInteger.valueOf(n))) {
                break;
            }
        }
        return key;
    }
}
