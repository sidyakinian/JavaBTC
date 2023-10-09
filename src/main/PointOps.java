package src.main;
import java.math.BigInteger;

public class PointOps {

    public static Point add(Point lpoint, Point rpoint) {
        if (lpoint.equals(Point.zeroPoint)) {
            return rpoint;
        }
        if (rpoint.equals(Point.zeroPoint)) {
            return lpoint;
        }

        if (lpoint.x().equals(rpoint.x()) && !lpoint.y().equals(rpoint.y())) {
            return Point.zeroPoint;
        }

        BigInteger m;
        Curve curve = lpoint.curve();

        if (lpoint.x().equals(rpoint.x())) { 
            m = (lpoint.x().pow(2).multiply(BigInteger.valueOf(3)).add(curve.a()))
                    .multiply(lpoint.y().multiply(BigInteger.valueOf(2)).modInverse(curve.p()));
        } else {
            m = (lpoint.y().subtract(rpoint.y()))
                    .multiply(lpoint.x().subtract(rpoint.x()).modInverse(curve.p()));
        }

        BigInteger rx = (m.pow(2).subtract(lpoint.x()).subtract(rpoint.x())).mod(curve.p());
        BigInteger ry = (m.multiply(rx.subtract(lpoint.x())).negate().add(lpoint.y())).mod(curve.p());

        return new Point(curve, rx, ry);
    }

    public static Point multiply(Point point, BigInteger scalar) {
        Point result = Point.zeroPoint;
        Point append = point;
        while (!scalar.equals(BigInteger.ZERO)) {
            if (scalar.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                result = add(result, append);
            }
            append = add(append, append);
            scalar = scalar.shiftRight(1);
        }
        return result;
    }
}
