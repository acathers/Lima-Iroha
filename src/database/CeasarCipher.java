package database;

import java.lang.StringBuilder;
import java.util.Scanner;
import ui.SaideesCiph;

public class CeasarCipher {

    //variables for the constructor and the encryption and decryption key. Default is set to 3 but there are methods to customize the key.

    private String ccFunction;
    private String ccParameter;
    private String ccHelp;
    private static int encryDef = 3;
    private static int decryDef = 3;

    //Constructor sets the variables for the class. 'ccFunction' is Encrypt or Decrypt, 'ccParameter' will be the key which is 3 by default, 'ccHelp' is used for triggering help.

    public CeasarCipher(String ccFunction, String ccParameter, String ccHelp) {
        this.ccFunction = ccFunction;
        this.ccParameter = ccParameter;
        this.ccHelp = ccHelp;
    }

    //Class is ran from here, this method should execute anything in the class needed from the command. The if statment sorts out the command and executes the methods as needed.

    public void runCC() {

        System.out.println();
        System.out.println("Input text. Letters and spaces only.");
        System.out.println();

        //This is where text to be encrypted or decrypted is put in.

        String input = ui.SaideesCiph.sc.nextLine();

        // if statment that uses the variables ccFunction and ccParameter to determine what to do to the text.

        if (this.ccParameter != null) {
            int ccParameterInt = Integer.parseInt(this.ccParameter);
            setEncrypt(ccParameterInt);
        }

        if (this.ccFunction.equalsIgnoreCase("encrypt")) {
                System.out.println(encryptText(input));
        }
        else if (this.ccFunction.equalsIgnoreCase("decrypt")) {
            System.out.println(decryptText(input));
        }
        else if (this.ccFunction.equalsIgnoreCase("help")) {
            System.out.println("You should get help, but I have yet to develop help for this part of the program at this time.");
        }
        else {
            System.out.println(encryptText("Would you like to encrypt or decrypt a message?"));
        }

        if (this.ccHelp != null) {
            System.out.println("Help message!");
        }
    }

    public static void setEncrypt(int x) {
        CeasarCipher.encryDef = x;
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

    public static void setDecrypt(int x) {
        CeasarCipher.decryDef = x;
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
