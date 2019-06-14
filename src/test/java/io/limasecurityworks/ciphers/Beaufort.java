package io.limasecurityworks.ciphers;

import io.limasecurityworks.processes.*;

public class Beaufort {

    private String function;
    private String key;
    private String help;
    private String about;

    private char tabulaRecta[][] = {{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A'}, {'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'}, {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'}, {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'}, {'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E'}, {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F'}, {'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}, {'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}, {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}, {'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'}, {'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'}, {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'}, {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'}, {'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'}, {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'}, {'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'}, {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'}, {'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'}, {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'}, {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'}, {'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'}, {'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'}, {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'}, {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'}};

    public Beaufort(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    public void runBeaufort() {

        if (this.help != null) {

            if (this.function != null && this.key != null) {
                System.out.println("You have entered a command with a function to either encrypt or decrypt with a key. The key must be shorter than the input text to be encrypted or decrypted.");
            }
            else if (this.function != null) {
                System.out.println("You may choose to either 'encrypt' or 'decrypt' a message with the Beaufort Cipher. This cipher will require a key which you will be promted to enter later if you did not specify at the main command line.");
            }
            else {
                System.out.println("Beaufort Cipher will ask you to encrypt or decrypt and will require a key, the key must contain only letters. Uppercase or lowercase does not matter. The key must also be less characters than the input text to be encrypted or decrypted");
            }
        }

        else if (this.about != null) {
            System.out.println("\n" + "The Beaufort cipher, created by Sir Francis Beaufort, is a substitution cipher similar to the Vigenère cipher, with a slightly modified enciphering mechanism and tableau. Its most famous application was in a rotor-based cipher machine, the Hagelin M-209. The Beaufort cipher is based on the Beaufort square which is essentially the same as a Vigenère square but in reverse order starting with the letter \"Z\" in the first row, where the first row and the last column serve the same purpose. "  + "(\"Beaufort cipher,\" n.d.) ");
        }

        else {

            // Find out if there is a function, if not, get it.

            if (this.function == null) {
                function = Function.getFunction();
            }

            // Find out if key have been suplemented, if not, get them.

            if (this.key == null) {

                System.out.print("Input key: ");

                this.key = io.limasecurityworks.ui.Iroha.sc.nextLine();

                while (!isAlpha(this.key) || hasSpaces(this.key)) {

                    System.out.print("The key must contain only letters with no spaces and it must be shorter than the text to be encrypted. Enter key: ");

                    this.key = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }
            }

            // Get input text and execute cipher.

            System.out.print("Input text: ");

            String inputText = io.limasecurityworks.ui.Iroha.sc.nextLine();

            StringBuilder inputTextSB = new StringBuilder(inputText);

            for (int i = 0; i < inputTextSB.length(); i++) {

                if (!Character.isLetter(inputTextSB.charAt(i))) {

                    inputTextSB.deleteCharAt(i);
                }
            }

            String inputTextLetters = inputTextSB.toString();

            if (this.function.equalsIgnoreCase("encrypt")) {

                String encryptedText = encryptText(inputTextLetters);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key:      " + this.key + "\n" + "Input:    " + inputText + "\n" + "Output:   " + encryptedText);
            }

            else if (this.function.equalsIgnoreCase("decrypt")) {

                String decryptedText = decryptText(inputTextLetters);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key:      " + this.key + "\n" + "Input:    " + inputText + "\n" + "Output:   " + decryptedText);
            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    /*
    * steps needed for encryption
    * 1. take the key and repeat the key until it is the same length as the input.
    * 2. Take column(input char) and find position of (key char) and produce row char that matches.
    * Note: tabulaRecta[y][x]. or tabulaRecta[column][row]
    */

    public String encryptText(String input) {

        System.out.println(input);

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyExtended = keyUC;
        int counter = 0;

        //Makes the key repeat itself until the length of input.

        for (int i = 0; i < input.length() - keyUC.length(); i++) {

            if (keyUC.length() < input.length()) {

                keyExtended += Character.toString(keyUC.charAt(counter));
                counter++;

                if (counter == keyUC.length()) {

                    counter = 0;
                }
            }
        }

        char[] output = new char[inputUC.length()];

        //Makes a string of column (input char), and finds key char in string, then identifies row char for encryption.

        for (int i = 0; i < inputUC.length(); i++) {

            String columnString = "";

            for (int j = 0; j < 26; j++) {

                columnString = columnString + tabulaRecta[alphabet.indexOf(inputUC.charAt(i))][j];
            }

            output[i] = alphabet.charAt(columnString.indexOf(keyExtended.charAt(i)));
        }

        return String.valueOf(output);
    }

    /*
    * Same algorithm to decrypt.
    */

    public String decryptText(String input) {

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyExtended = keyUC;
        int counter = 0;

        //Makes the key repeat itself until the length of input.

        for (int i = 0; i < input.length() - keyUC.length(); i++) {

            if (keyUC.length() < input.length()) {

                keyExtended += Character.toString(keyUC.charAt(counter));
                counter++;

                if (counter == keyUC.length()) {

                    counter = 0;
                }
            }
        }

        char[] output = new char[inputUC.length()];

        //Makes a string of column (input char), and finds key char in string, then identifies row char for encryption.

        for (int i = 0; i < inputUC.length(); i++) {

            String columnString = "";

            for (int j = 0; j < 26; j++) {

                columnString = columnString + tabulaRecta[alphabet.indexOf(inputUC.charAt(i))][j];
            }

            output[i] = alphabet.charAt(columnString.indexOf(keyExtended.charAt(i)));
        }

        return String.valueOf(output);
    }

    /*
    * Method to ensure that all characters in a string are letters.
    *
    */

    public boolean isAlpha(String input) {

        char[] chars = input.toCharArray();

        boolean allLetters = true;

        for (char c : chars) {
            if (!Character.isLetter(c) && c != ' ') {
                allLetters = false;
                break;
            }
        }
        return allLetters;
    }

    public boolean hasSpaces(String input) {

        char[] chars = input.toCharArray();

        boolean hasSpaces = false;

        for (char c : chars) {
            if (c == ' ') {
                hasSpaces = true;
            }
        }
        return hasSpaces;
    }
}
