package src.main;
import java.math.BigInteger;
import java.util.Formatter;
import src.main.EuclidianResult;

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

    public static EuclidianResult extendedEuclideanAlgorithm(BigInteger a, BigInteger b) {
        BigInteger oldR = a, r = b;
        BigInteger oldS = BigInteger.ONE, s = BigInteger.ZERO;
        BigInteger oldT = BigInteger.ZERO, t = BigInteger.ONE;

        while (!r.equals(BigInteger.ZERO)) {
            BigInteger quotient = oldR.divide(r);

            BigInteger tempR = r;
            r = oldR.subtract(quotient.multiply(r));
            oldR = tempR;

            BigInteger tempS = s;
            s = oldS.subtract(quotient.multiply(s));
            oldS = tempS;

            BigInteger tempT = t;
            t = oldT.subtract(quotient.multiply(t));
            oldT = tempT;
        }

        return new EuclidianResult(oldR, oldS, oldT);
    }
}