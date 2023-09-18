package src.main;

import src.main.Hasher;
import src.main.Utils;

public class Main {
    public static void main(String[] args) {
        String message = "Hello JavaBTC!";
        System.out.println(message);

        byte[] messageBytes = message.getBytes();
        byte[] hash = Hasher.hashSHA256(messageBytes);
        System.out.println("Hash: " + Utils.byteArrayToHex(hash));
    }
}