package src.main;
import java.security.MessageDigest;

public class Hasher {
    public static byte[] hashSHA256(byte[] input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(input);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
