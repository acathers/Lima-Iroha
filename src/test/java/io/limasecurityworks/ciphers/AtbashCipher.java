package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;


public class AtbashCipher {

    private String function;
    private String key = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    private String help;
    private String about;
    private String charLibrary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public AtbashCipher (String function, String help, String about) {
        this.function = function;
        this.help = help;
        this.about = about;
    }

    public void runAtbash() {

        // Only two possible commands for help with Atbash, that would be 'Atbash help' and 'Atbash encrypt/decrypt'.

        if (this.help != null) {
            if (this.function != null) {
                System.out.println("\n" + "You have entered a command for Atbash Cipher with a function. The only two options for a function is to encrypt or decrypt. ");
            }
            else {
                System.out.println("This cipher does not allow you to use a key, the key is set and the same every time because the key is the alphabet in reverse order. So you will just need to put in the text using only letters to encrypt and put in encrypted text to decrypt.");
            }

        }

        // You no longer need to worry about a command containing about and help in the same command due to ComTree.java taking care of that. If about is not null, then help has to be null and vice versa. The about command should only work with Atbash like this, 'Atbash about'.

        else if (this.about != null) {
            System.out.println("\n" + "Atbash is one of the oldest ciphers but is also one of the easiest to break.");
        }

        //Next, check to see if a function was provided. if not, get the function.

        else if (this.function == null) {
            System.out.print("\n" + "Would you like to Encrypt or Decrypt your text?: ");

            this.function = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")){
                System.out.print("\n" + "Invalid function for Atbash Cipher. Please enter 'Encrypt' or 'Decrypt':  ");

                String encDecResponseNull = io.limasecurityworks.ui.Iroha.sc.nextLine();

                if (!encDecResponseNull.equalsIgnoreCase("encrypt") && !encDecResponseNull.equalsIgnoreCase("decrypt")) {
                    System.out.print("\n" + "Invalid function for Atbash Cipher. Please enter 'Encrypt' or 'Decrypt':  ");
                }
                else {
                    this.function = encDecResponseNull;
                }
            }
        }

        //If there is a function and the function is not valid, get a new function.

        else if (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")) {
            System.out.print("\n" + "Invalid function for Atbash Cipher. Please enter 'Encrypt' or 'Decrypt':  ");

            while (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")){

                String encDecResponseNull = io.limasecurityworks.ui.Iroha.sc.nextLine();

                if (!encDecResponseNull.equalsIgnoreCase("encrypt") && !encDecResponseNull.equalsIgnoreCase("decrypt")) {
                    System.out.print("\n" + "Invalid function for Atbash Cipher. Please enter 'Encrypt' or 'Decrypt':  ");
                }
                else {
                    this.function = encDecResponseNull;
                }
            }
        }

        // Get input text and complete the encryption or decryption. help == null in the if statement is necessary to prevent it from running after a help command is entered.

        if (help == null && about == null) {
            System.out.println();
            System.out.println("Input text. Letters and spaces only.");
            System.out.println();
            System.out.print("Input Text:      ");

            //This is where text to be encrypted or decrypted is put in.

            String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

            // if statment that uses the variables function and key to determine what to do to the text.

            if (this.function.equalsIgnoreCase("encrypt")) {
                    System.out.print("Encrypted Text:  " + encryptText(input) + "\n");
            }
            else if (this.function.equalsIgnoreCase("decrypt")) {
                System.out.print("Decrypted Text:  " + decryptText(input) + "\n");
            }
            else {
                System.out.println(encryptText("This should be an impossible function error."));
            }
        }
    }

    // Used to encrypt text.

    public String encryptText(String input) {

        String inputUC = input.toUpperCase();

        StringBuilder outputSB = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (Character.toString(inputUC.charAt(i)).equalsIgnoreCase(" ")) {

                outputSB.append(Character.toString(inputUC.charAt(i)));
            }
            else {
                for (int j = 0; j < this.charLibrary.length(); j++){
                    if (Character.toString(inputUC.charAt(i)).equalsIgnoreCase(Character.toString(this.charLibrary.charAt(j)))) {

                        outputSB.append(this.key.charAt(j));
                    }
                }
            }
        }

    return outputSB.toString();

    }

    // Used to decrypt text.

    public String decryptText(String input) {

        String inputUC = input.toUpperCase();

        StringBuilder outputSB = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (Character.toString(inputUC.charAt(i)).equalsIgnoreCase(" ")) {

                outputSB.append(Character.toString(inputUC.charAt(i)));
            }
            else {
                for (int j = 0; j < this.charLibrary.length(); j++) {
                    if (Character.toString(inputUC.charAt(i)).equalsIgnoreCase(Character.toString(this.key.charAt(j)))) {

                        outputSB.append(this.charLibrary.charAt(j));
                    }
                }
            }

        }

    return outputSB.toString();

    }
}
