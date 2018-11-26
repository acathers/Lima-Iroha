package ui;

public class Decrypt {

    protected int decryDef = -4;

    public static void setDecrypt(decry) {
        int decryDef = -decry;
    }

    public static void decryptText(String input) {
        String output = "";
        for(int i = 0; i < input; i++) {
            char place = input.charAt(i);
            char decryPlace = place + decryDef;
            output.append(encryPlace);
        }
        System.out.println(output);
    }
}
