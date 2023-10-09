package src.main;

import java.math.BigInteger;

public record Curve(BigInteger p, BigInteger a, BigInteger b) {
    public static final Curve bitcoinCurve = new Curve(
        new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16),
        new BigInteger("0x0000000000000000000000000000000000000000000000000000000000000000", 16),
        new BigInteger("0x0000000000000000000000000000000000000000000000000000000000000007", 16)
    );

    public static final Curve zeroCurve = new Curve(
        new BigInteger("0"),
        new BigInteger("0"),
        new BigInteger("0")
    );
}