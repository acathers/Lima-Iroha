package ui;

import java.lang.StringBuilder;

public class Encrypt {

    private static int encryDef = 1;

    public void encrypt() {
    }

    public static void setEncrypt(int x) {
        Encrypt.encryDef = x;
    }

    public String encryptText(String input) {

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char place = input.charAt(i);
            char encryPlace = (char)(place + encryDef);
            output.append(encryPlace);
        }
        return output.toString();
    }
}
