<img src="https://github.com/sidyakinian/JavaBTC/assets/34050187/b2235048-63fe-4e29-b857-bc5159c75102" width=100/>

## JavaBTC

JavaBTC is a Bitcoin implementation in Java, developed for educational purposes (including my own learning).

## Features
**SHA-256:** A Java implementation of the SHA-256 hash function adhering to the NIST FIPS 180-4 specification. Designed for educational examination rather than optimized performance.

**Key Management:** Functionality to generate Bitcoin secret/public key pairs and associated base58check compressed addresses.

**Digital Signatures:** Implementation of the Elliptic Curve Digital Signature Algorithm (ECDSA) used in Bitcoin transaction authentication.

**Transactions:** Java implementation for creating and parsing Bitcoin transaction objects, including legacy and segwit transactions. Current focus is on the p2pkh transaction type.

**Blocks:** Java representation of Bitcoin blocks, the fundamental components of the Bitcoin blockchain.

**Lightweight Node:** A basic Bitcoin node in Java, showcasing network operations like connecting to peers, handshaking, and requesting block headers.

## Implementation details

Bitcoin uses elliptic curve algorithms to digitally sign transactions. Specifically it uses the `secp256k1` curve:

```java
public record Curve(BigInteger p, BigInteger a, BigInteger b) {
    public static final Curve bitcoinCurve = new Curve(
        new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16),
        new BigInteger("0x0000000000000000000000000000000000000000000000000000000000000000", 16),
        new BigInteger("0x0000000000000000000000000000000000000000000000000000000000000007", 16)
    );

    ...
}
```

which happens to look like this:

![elliptic_curve1](https://github.com/sidyakinian/JavaBTC/assets/34050187/4fad7360-3748-44cb-a50b-61c27c642883)

As you can see, the elliptic curve uses 256-bit integers for initialization, which requires using `BigInteger` class in Java. Since `BigInteger` is not a native Java class and Java doesn't allow overloading binary operators, we have to use `BigInteger` API for mathematical operations. For example, here is the implementation of point addition:


```java
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
```

## Dependencies

The project includes a dependency for RipeMD160 hashing algorithm. (From-scratch implementation of this algortihm is out of scope of this project)
