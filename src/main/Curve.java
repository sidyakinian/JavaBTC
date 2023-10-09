package src.main;

public record Curve(int p, int a, int b) {
    public static final Curve bitcoin_curve = new Curve(
        Integer.parseInt("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16),
        Integer.parseInt("0x0000000000000000000000000000000000000000000000000000000000000000", 16),
        Integer.parseInt("0x0000000000000000000000000000000000000000000000000000000000000007", 16)
    );
}