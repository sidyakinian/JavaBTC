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

## Dependencies

The project includes a dependency for RipeMD160 hashing algorithm. (From-scratch implementation of this algortihm is out of scope of this project)
