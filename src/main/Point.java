package src.main;
import java.math.BigInteger;
import java.util.Optional;

public record Point(Curve curve, BigInteger x, BigInteger y) {
    public static final Point bitcoinPoint = new Point(
        Curve.bitcoinCurve,
        new BigInteger("0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16),
        new BigInteger("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16)
    );

    public static final Point zeroPoint = new Point(
        Curve.zeroCurve,
        new BigInteger("0"),
        new BigInteger("0")
    );
    // TODO: address function -> generate address from Point

    // TODO: encode function (only to use in the address function)

    // TODO: decode function (used in transactions)
}
