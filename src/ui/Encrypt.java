package ui;

public class Encrypt {

    protected int encryDef = 4;

    public static void setEncrypt(encry) {
        int encryDef = encry;
    }

    public static void getEncrypt() {
        return encryDef;
    }

    public static void encryptText(String input) {
        String output = "";
        for(int i = 0; i < input; i++) {
            char place = input.charAt(i);
            char encryPlace = place + encryDef;
            output.append(encryPlace);
        }
        System.out.println(output);
    }
}
