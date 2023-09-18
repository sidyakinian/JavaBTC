public class Main {
    public static void main(String[] args) {
        System.out.println("Hello JavaBTC!");

        String message = "Hello JavaBTC!";
        byte[] messageBytes = message.getBytes();
        byte[] hash = Hasher.hashSHA256(messageBytes);
        System.out.println("Hash: " + Utils.byteArrayToHex(hash));
    }
}