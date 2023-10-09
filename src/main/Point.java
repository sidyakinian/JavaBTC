package src.main;

public record Point(Curve curve, int x, int y) {
    public static final Point bitcoinPoint = new Point(
        Curve.bitcoin_curve,
        Integer.parseInt("0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16),
        Integer.parseInt("0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8", 16)
    );
    // TODO: address function -> generate address from Point

    // TODO: encode function (only to use in the address function)
}
