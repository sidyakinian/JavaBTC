package src.main;

public record Generator(Point g, int n) {
    static public final Generator bitcoinGenerator = new Generator(
        Point.bitcoinPoint,
        Integer.parseInt("0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16)
    );
}