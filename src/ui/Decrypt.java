package ui;

public class Decrypt {

    protected int decryDef = -4;

    setDecrypt(decry) {
        int decryDef = -decry;
    }

    decryptText(String input) {
        String output = "";
        for(int i = 0; i < input; i++) {
            char place = input.charAt(i);
            char decryPlace = place + decryDef;
            output.append(encryPlace);
        }
        System.out.println(output);
    }
}
