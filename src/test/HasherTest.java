package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import src.main.Hasher;
import src.main.Utils;

public class HasherTest {

    @Test
    public void testHashSHA256() throws Exception {
        byte[] result = Hasher.hashSHA256("test".getBytes("UTF-8"));
        assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", Utils.byteArrayToHex(result));
    }

}

