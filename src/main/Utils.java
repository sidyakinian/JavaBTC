package src.main;
import java.math.BigInteger;
import java.util.Formatter;

public class Utils {
    public static String byteArrayToHex(final byte[] hash) {
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }
    }

    public static boolean lessThan(BigInteger a, BigInteger b) {
        return a.compareTo(b) < 0;
    }
}