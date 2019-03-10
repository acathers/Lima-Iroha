package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;

public class CaesarCipher {

    //variables for the constructor and the encryption and decryption key. Default is set to 3 but there are methods to customize the key.

    private String function;
    private String key;
    private String help;
    private String about;
    private static int encryDef = 3;
    private static int decryDef = -3;

    //Constructor sets the variables for the class. 'function' is Encrypt or Decrypt, 'key' will be the key which is 3 by default, 'help' is used for triggering help.

    public CaesarCipher(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    //Class is ran from here, this method should execute anything in the class needed from the command. The if statment sorts out the command and executes the methods as needed.

    public void runCC() {

        //First check if the command requests help and act on in appropriately.

        if (this.help != null) {
            if (function != null && key != null) {
                System.out.println("\n" + "You have entered a command for Caesar Cipher with a function and a key. The only two options for a function is to encrypt or decrypt. The key is simply how many characters your original text will shift. If you use the default, all characters of the letter 'A' will be shifted to the right by 3. So the letter 'A' will become 'D'. The key is how many characters each letter will shift. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
            else if (function != null) {
                System.out.println("\n" + "You have entered a command for Caesars Cipher to encrypt or decrypt a message. Since you did not specify a key, the default key of 3 will be used. Each letter in your message will be shifted three characters to the right. So an 'A' will become a 'D'. Lowercase and upercase do not matter as the message will be displayed in all uppercase. Do not use any punctuation, numbers or special characters. Letters and spaces only.");
            }
            else {
                System.out.println("\n" + "Starting command for Caesar Cipher will be in the format of 'Caesar encrypt 5'. You can either encrypt or decrypt on the second word and you may edit how many characters your letters shift in the third word. If you want to edit the key which is how many characters it shifts, you need to input that when initializing Caesar Cipher like in the example");
            }
        }

        else if (about != null) {
            System.out.println("\n" + "In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence" + "\n" + "\n" + "--Source: Suetonius, Vita Divi Julii 56.6");
        }

        //Next, check to see if a function was provided. if not, get the function.

        else if (function == null) {
            System.out.print("\n" + "Would you like to Encrypt or Decrypt your text?: ");

            this.function = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")){
                System.out.print("\n" + "Invalid function for Caesar Cipher. Please enter 'Encrypt' or 'Decrypt':  ");

                String encDecResponseNull = io.limasecurityworks.ui.Iroha.sc.nextLine();

                if (!encDecResponseNull.equalsIgnoreCase("encrypt") && !encDecResponseNull.equalsIgnoreCase("decrypt")) {
                    System.out.print("\n" + "Invalid function for Caesar Cipher. Please enter 'Encrypt' or 'Decrypt':  ");
                }
                else {
                    this.function = encDecResponseNull;
                }
            }

        }

        //If there is a fuction and the function is not valid, get a new function.

        else if (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")) {
            System.out.print("\n" + "Invalid function for Caesar Cipher. Please enter 'Encrypt' or 'Decrypt':  ");

            while (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")){

                String encDecResponseNull = io.limasecurityworks.ui.Iroha.sc.nextLine();

                if (!encDecResponseNull.equalsIgnoreCase("encrypt") && !encDecResponseNull.equalsIgnoreCase("decrypt")) {
                    System.out.print("\n" + "Invalid function for Caesar Cipher. Please enter 'Encrypt' or 'Decrypt':  ");
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

            if (this.key != null) {
                if (this.function.equalsIgnoreCase("encrypt")) {
                    int keyInt = Integer.parseInt(this.key);
                    setEncryptKey(keyInt);
                }
                else {
                    int keyInt = Integer.parseInt(this.key);
                    setDecryptKey(keyInt);
                }

            }

            if (this.function.equalsIgnoreCase("encrypt")) {
                    System.out.print("Encrypted Text:  " + encryptText(input) + "\n");
            }
            else if (this.function.equalsIgnoreCase("decrypt")) {
                System.out.print("Decrypted Text:  " + decryptText(input) + "\n");
            }
            else {
                System.out.println("This should be an impossible function error.");
            }
        }
    }

    //Used to set the key for encryption.

    public static void setEncryptKey(int x) {
        CaesarCipher.encryDef = x;
    }

    //Used to encrypt your text.

    public String encryptText(String input) {

        String inputUC = input.toUpperCase();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputUC.length(); i++) {
            if (inputUC.charAt(i) == 32) {
                output.append(inputUC.charAt(i));
            }
            else if (inputUC.charAt(i) > 90 - encryDef) {
                char place = inputUC.charAt(i);
                char encryPlace = (char)(place + encryDef);
                char encryPlaceWrap = (char)(encryPlace - 26);
                output.append(encryPlaceWrap);
            }
            else {
                char place = inputUC.charAt(i);
                char encryPlace = (char)(place + encryDef);
                output.append(encryPlace);
            }

        }
        return output.toString();
    }

    //Used to set the key for decryption.

    public static void setDecryptKey(int x) {
        CaesarCipher.decryDef = -x;
    }

    //Used to decrypt your text.

    public String decryptText(String input) {

        String inputUC = input.toUpperCase();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputUC.length(); i++) {
            if (inputUC.charAt(i) == 32) {
                output.append(inputUC.charAt(i));
            }
            else if (inputUC.charAt(i) < 65 - decryDef) {
                char place = inputUC.charAt(i);
                char decryPlace = (char)(place + decryDef);
                char decryPlaceWrap = (char)(decryPlace + 26);
                output.append(decryPlaceWrap);
            }
            else {
                char place = inputUC.charAt(i);
                char decryPlace = (char)(place + decryDef);
                output.append(decryPlace);
            }

        }
        return output.toString();
    }
}
