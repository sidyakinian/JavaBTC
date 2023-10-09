package src.main;

import java.math.BigInteger;

public record Generator(Point g, BigInteger n) {
    static public final Generator bitcoinGenerator = new Generator(
        Point.bitcoinPoint,
        new BigInteger("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16)
    );
}