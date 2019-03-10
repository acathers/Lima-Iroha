package io.limasecurityworks.ciphers;

import java.util.HashMap;
import java.util.Map;

public class BaconianCipher {

    String function;
    String help;
    String about;

    public BaconianCipher(String function, String help, String about) {
        this.function = function;
        this.help = help;
        this.about = about;
    }

    public void runBaconian() {

        HashMap<String, Integer> encryptionMap = new HashMap<>();

        encryptionMap.put("a", 00000);
        encryptionMap.put("b", 00000);
        encryptionMap.put("c", 00000);
        encryptionMap.put("d", 00000);
        encryptionMap.put("e", 00000);
        encryptionMap.put("f", 00000);
        encryptionMap.put("g", 00000);
        encryptionMap.put("h", 00000);
        encryptionMap.put("i", 00000);
        encryptionMap.put("j", 00000);
        encryptionMap.put("k", 00000);
        encryptionMap.put("l", 00000);
        encryptionMap.put("m", 00000);
        encryptionMap.put("n", 00000);
        encryptionMap.put("o", 00000);
        encryptionMap.put("p", 00000);
        encryptionMap.put("q", 00000);
        encryptionMap.put("r", 00000);
        encryptionMap.put("s", 00000);
        encryptionMap.put("t", 00000);
        encryptionMap.put("u", 00000);
        encryptionMap.put("v", 00000);
        encryptionMap.put("w", 00000);
        encryptionMap.put("x", 00000);
        encryptionMap.put("y", 00000);
        encryptionMap.put("z", 00000);
    }

    public String encryptText(String input) {
        String output = "";

    }
    public String decryptText(String input) {
        String output = "";

        return output;
    }
}
