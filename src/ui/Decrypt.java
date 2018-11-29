package ui;

import java.lang.StringBuilder;

public class Decrypt {

    private static int decryDef = 3;

    public void decrypt() {
    }

    public static void setDecrypt(int x) {
        Decrypt.decryDef = x;
    }

    public String decryptText(String input) {

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char place = input.charAt(i);
            char decryPlace = (char)(place + decryDef);
            output.append(decryPlace);
        }
        return output.toString();
    }
}
