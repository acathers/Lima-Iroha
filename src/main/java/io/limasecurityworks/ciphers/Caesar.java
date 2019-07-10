package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;
import io.limasecurityworks.processes.*;
import io.limasecurityworks.printables.*;
import io.limasecurityworks.tools.*;

public class Caesar {

    // variables for the constructor and the encryption and decryption key. Default
    // is set to 3 but there are methods to customize the key.

    private String function;
    private String key;
    private String help;
    private String about;
    private static int encryDef = 3;
    private static int decryDef = -3;

    // Constructor sets the variables for the class. 'function' is Encrypt or
    // Decrypt, 'key' will be the key which is 3 by default, 'help' is used for
    // triggering help.

    public Caesar(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    // Class is ran from here, this method should execute anything in the class
    // needed from the command. The if statment sorts out the command and executes
    // the methods as needed.

    public void runCC() {

        // First check if the command requests help and act on in appropriately.

        if (this.help != null) {
            if (function != null && key != null) {
                System.out.println("\n"
                        + "You have entered a command for Caesar Cipher with a function and a key. The only two options for a function is to encrypt or decrypt. The key is simply how many characters your original text will shift. If you use the default, all characters of the letter 'A' will be shifted to the right by 3. So the letter 'A' will become 'D'. The key is how many characters each letter will shift. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
            else if (function != null) {
                System.out.println("\n"
                        + "You have entered a command for Caesars Cipher to encrypt or decrypt a message. Since you did not specify a key, the default key of 3 will be used. Each letter in your message will be shifted three characters to the right. So an 'A' will become a 'D'. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
            else {
                System.out.println("\n"
                        + "Starting command for Caesar Cipher will be in the format of 'Caesar encrypt 5'. You can either encrypt or decrypt on the second word and you may edit how many characters your letters shift in the third word. If you want to edit the key which is how many characters it shifts, you need to input that when initializing Caesar Cipher like in the example");
            }
        }

        else if (about != null) {
            System.out.println("\n"
                    + "In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence"
                    + "\n" + "\n" + "--Source: Suetonius, Vita Divi Julii 56.6");
        }

        // Next, check to see if a function was provided. if not, get the function. If
        // there is a function, ensure that it is a correct function.

        else if (function == null) {
            function = Function.getFunction();

        }

        // If there is a fuction and the function is not valid, get a new function.

        else if (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")) {
            function = Function.checkFunction(function);
        }

        // Get input text and complete the encryption or decryption. help == null in the
        // if statement is necessary to prevent it from running after a help command is
        // entered.

        if (help == null && about == null) {

            // if statment that uses the variables function and key to determine what to do
            // to the text.

            if (key == null) {
                if (this.function.equalsIgnoreCase("encrypt")) {
                    key = "3";
                }
                else {
                    key = "-3";
                }
            }

            else {
                while (!checkKey(key)) {
                    System.out.println();
                    System.out.println("The key may only contain numbers and must be between 1 and 26.");
                    System.out.print("Input key, numbers only: ");
                    key = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }
            }

            // Get text to be encrypted.
            System.out.print("Input Text:      ");

            String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (!checkInput(input)) {
                System.out.println();
                System.out.println("Numbers can not be encrypted with Caesars Cipher, please spell them out.");
                System.out.print("Input text without numbers:");

                input = io.limasecurityworks.ui.Iroha.sc.nextLine();
            }

            if (this.function.equalsIgnoreCase("encrypt")) {
                Printables.createPrintout(input, function, null, encryptText(input), key);
            }
            else if (this.function.equalsIgnoreCase("decrypt")) {
                Printables.createPrintout(input, function, null, encryptText(input), key);

            }
            else {
                System.out.println("This should be an impossible function error. Function is not encrypt or decrypt");
            }
        }
    }

    // check the key to ensure it is valid, must be all numbers.
    public static boolean checkKey(String input) {

        if (StringBoolean.isNumeric(input) && (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 26)) {
            return true;
        }
        else {
            return false;
        }
    }

    // check the input to ensure it is valid (no numbers), the rest aside from
    // letters will be deleted.
    public static boolean checkInput(String input) {

        if (StringBoolean.hasDigits(input)) {
            return false;
        }
        else {
            return true;
        }
    }

    public static String cleanInput(String input) {

        String cleanInput;

        cleanInput = ReChars.reAllNonLettersLeaveSpaces(input);

        return cleanInput;
    }

    // Used to encrypt your text.

    public String encryptText(String input) {

        encryDef = Integer.parseInt(key);

        String inputUC = input.toUpperCase();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputUC.length(); i++) {
            if (inputUC.charAt(i) == 32) {
                output.append(inputUC.charAt(i));
            }
            else if (inputUC.charAt(i) > 90 - encryDef) {
                char place = inputUC.charAt(i);
                char encryPlace = (char) (place + encryDef);
                char encryPlaceWrap = (char) (encryPlace - 26);
                output.append(encryPlaceWrap);
            }
            else {
                char place = inputUC.charAt(i);
                char encryPlace = (char) (place + encryDef);
                output.append(encryPlace);
            }
        }
        return output.toString();
    }

    // Used to decrypt your text.

    public String decryptText(String input) {

        decryDef = -1 * Integer.parseInt(key);

        String inputUC = input.toUpperCase();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputUC.length(); i++) {
            if (inputUC.charAt(i) == 32) {
                output.append(inputUC.charAt(i));
            }
            else if (inputUC.charAt(i) < 65 - decryDef) {
                char place = inputUC.charAt(i);
                char decryPlace = (char) (place + decryDef);
                char decryPlaceWrap = (char) (decryPlace + 26);
                output.append(decryPlaceWrap);
            }
            else {
                char place = inputUC.charAt(i);
                char decryPlace = (char) (place + decryDef);
                output.append(decryPlace);
            }
        }
        return output.toString();
    }
}
