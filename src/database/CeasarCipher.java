package database;

import java.lang.StringBuilder;
import java.util.Scanner;
import ui.SaideesCiph;

public class CeasarCipher {

    //variables for the constructor and the encryption and decryption key. Default is set to 3 but there are methods to customize the key.

    private String ccFunction;
    private String ccKey;
    private String ccHelp;
    private static int encryDef = 3;
    private static int decryDef = 3;

    //Constructor sets the variables for the class. 'ccFunction' is Encrypt or Decrypt, 'ccKey' will be the key which is 3 by default, 'ccHelp' is used for triggering help.

    public CeasarCipher(String ccFunction, String ccKey, String ccHelp) {
        this.ccFunction = ccFunction;
        this.ccKey = ccKey;
        this.ccHelp = ccHelp;
    }

    //Class is ran from here, this method should execute anything in the class needed from the command. The if statment sorts out the command and executes the methods as needed.

    public void runCC() {

        if (this.ccHelp != null) {
            if (ccFunction != null && ccKey != null) {
                System.out.println("\n" + "You have entered a command for Ceasar Cipher with a function and a key. The only two options for a function is to encrypt or decrypt. The key is simply how many characters your original text will shift. If you use the default, all characters of the letter 'A' will be shifted to the right by 3. So the letter 'A' will become 'D'. The key is how many characters each letter will shift. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
            else if (ccFunction != null) {
                System.out.println("\n" + "You have entered a command for Ceasars Cipher to encrypt or decrypt a message. Since you did not specify a key, the default key of 3 will be used. Each letter in your message will be shifted three characters to the right. So an 'A' will become a 'D'. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
        }
        else {
            System.out.println();
            System.out.println("Input text. Letters and spaces only.");
            System.out.println();

            //This is where text to be encrypted or decrypted is put in.

            String input = ui.SaideesCiph.sc.nextLine();

            // if statment that uses the variables ccFunction and ccKey to determine what to do to the text.

            if (this.ccKey != null) {
                int ccKeyInt = Integer.parseInt(this.ccKey);
                setEncrypt(ccKeyInt);
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
        }

    }

    //Used to set the key for encryption.

    public static void setEncrypt(int x) {
        CeasarCipher.encryDef = x;
    }

    //Used to encrypt your text.

    public String encryptText(String input) {

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char place = input.charAt(i);
            char encryPlace = (char)(place + encryDef);
            output.append(encryPlace);
        }
        return output.toString();
    }

    //Used to set the key for decryption.

    public static void setDecrypt(int x) {
        CeasarCipher.decryDef = x;
    }

    //Used to decrypt your text.
    
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
