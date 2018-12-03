package database;

import java.lang.StringBuilder;
import java.util.Scanner;

public class CeasarsCipher {

    private String ccFunction;
    private String ccParameter = " ";
    private String ccHelp = " ";

    public CeasarsCipher(String ccFunction, String ccParameter, String ccHelp) {
        this.ccFunction = ccFunction;
        this.ccParameter = ccParameter;
        this.ccHelp = ccHelp;

        System.out.println();
        System.out.println("Input text. Letters and spaces only.");
        System.out.println();

        if (this.ccParameter != " ") {

            int ccParameterInt = Integer.parseInt(this.ccParameter);

            setEncrypt(ccParameterInt);
        }

        final Scanner ccsc = new Scanner(System.in);
        final String input = ccsc.nextLine();

        if (this.ccFunction.equalsIgnoreCase("encrypt")) {

                System.out.println(encryptText(input));
        }
        if (this.ccFunction.equalsIgnoreCase("decrypt")) {

            System.out.println(decryptText(input));
        }
        if (this.ccFunction.equalsIgnoreCase("help")) {

            System.out.println("You should get help, but I have yet to develop help for this part of the program at this time.");
        }
        else {
            System.out.println(encryptText("Would you like to encrypt or decrypt a message?"));
        }

        if (this.ccHelp != " ") {
            System.out.println("Help message!");
        }
        ccsc.close();
    }

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
