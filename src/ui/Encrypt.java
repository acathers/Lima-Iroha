package ui;

public class Encrypt {

    protected int encryDef = 4;

    setEncrypt(encry) {
        int encryDef = encry;
    }

    getEncrypt() {
        return encryDef;
    }

    encryptText(String input) {
        String output = "";
        for(int i = 0; i < input; i++) {
            char place = input.charAt(i);
            char encryPlace = place + encryDef;
            output.append(encryPlace);
        }
        System.out.println(output);
    }
}
