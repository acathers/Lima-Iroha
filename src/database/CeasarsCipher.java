package database;

import java.lang.StringBuilder;

public class CeasarsCipher {

    private static int encryDef = 3;

    public static void setEncrypt(int x) {
        CeasarsCipher.encryDef = x;
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

    private static int decryDef = 3;

    public static void setDecrypt(int x) {
        CeasarsCipher.decryDef = x;
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
