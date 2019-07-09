package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;
import io.limasecurityworks.processes.*;

public class ROT13 {

    // variables for the constructor and the encryption and decryption key. Default
    // is set to 3 but there are methods to customize the key.

    private String function;
    private String help;
    private String about;
    private static int encryDef = 13;

    // Constructor sets the variables for the class. 'function' is Encrypt or
    // Decrypt, 'key' will be the key which is 3 by default, 'help' is used for
    // triggering help.

    public ROT13(String function, String help, String about) {
        this.function = function;
        this.help = help;
        this.about = about;
    }

    // Class is ran from here, this method should execute anything in the class
    // needed from the command. The if statment sorts out the command and executes
    // the methods as needed.

    public void runROT13() {

        // First check if the command requests help and act on in appropriately.

        if (this.help != null) {
            if (function != null) {
                System.out.println("\n"
                        + "You have entered a command for ROT13 with a funtion. You may use any characters, but only letters will be encrypted, characters such as periods and exclamation points will just be printed in original order.");
            }
            else {
                System.out.println("\n"
                        + "Starting command for ROT13 will be in the format of 'ROT13 encrypt'. You can either encrypt or decrypt on the second word but you may just enter 'ROT13' and you will be prompted to answer whether you would like to encrypt to decrypt. There is no key for ROT13, that can be edited anyway. ROT13 works like a Caesar Cipher that is shifted to the right 13 characters on encryption. You may use any characters, but only letters will be encrypted, characters such as periods and exclamation points will just be printed in original order.");
            }
        }

        else if (about != null) {
            System.out.println("\n"
                    + "ROT13, sometimes hyphenated ROT-13, is like a Caesar Cipher shifted to 13. Because it only encrypts letters and there are 26 letters in the alphabet, encrypting encrypted text will decrypt text if that makes sense to you, because when encrypting you are basically shifting through half of the alphabet, shifting again brings you back where you started.");
        }

        // Next, check to see if a function was provided. if not, get the function.

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
            System.out.println();
            System.out.println("Input text. Letters and spaces only.");
            System.out.println();
            System.out.print("Input Text:      ");

            // This is where text to be encrypted or decrypted is put in.

            String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

            // if statment that uses the variables function and key to determine what to do
            // to the text.

            if (this.function.equalsIgnoreCase("encrypt")) {
                System.out.print("Encrypted Text:  " + encryptText(input) + "\n");
            }
            else if (this.function.equalsIgnoreCase("decrypt")) {
                System.out.print("Decrypted Text:  " + encryptText(input) + "\n");
            }
            else {
                System.out.println("This should be an impossible function error.");
            }
        }
    }

    // Used to encrypt your text.

    public String encryptText(String input) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                if (input.charAt(i) > 122 - encryDef) {
                    char place = input.charAt(i);
                    char encryPlace = (char) (place + encryDef);
                    char encryPlaceWrap = (char) (encryPlace - 26);
                    output.append(encryPlaceWrap);
                }
                else {
                    char place = input.charAt(i);
                    char encryPlace = (char) (place + encryDef);
                    output.append(encryPlace);
                }
            }
            else if (Character.isUpperCase(input.charAt(i))) {

                if (input.charAt(i) > 90 - encryDef) {
                    char place = input.charAt(i);
                    char encryPlace = (char) (place + encryDef);
                    char encryPlaceWrap = (char) (encryPlace - 26);
                    output.append(encryPlaceWrap);
                }
                else {
                    char place = input.charAt(i);
                    char encryPlace = (char) (place + encryDef);
                    output.append(encryPlace);
                }
            }
            else if (!Character.isUpperCase(input.charAt(i)) && !Character.isLowerCase(input.charAt(i))) {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}
