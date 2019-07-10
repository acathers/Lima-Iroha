package io.limasecurityworks.ciphers;

import io.limasecurityworks.printables.Printables;
import io.limasecurityworks.processes.*;

public class Vegenere {

    private String function;
    private String key;
    private String help;
    private String about;

    private char tabulaRecta[][] = { 
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' },
            { 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A' },
            { 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B' },
            { 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C' },
            { 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D' },
            { 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E' },
            { 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F' },
            { 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G' },
            { 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' },
            { 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' },
            { 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' },
            { 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' },
            { 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L' },
            { 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M' },
            { 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N' },
            { 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O' },
            { 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P' },
            { 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q' },
            { 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' },
            { 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S' },
            { 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T' },
            { 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U' },
            { 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V' },
            { 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W' },
            { 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X' },
            { 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' } 
        };

    public Vegenere(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    public void runVegenere() {

        if (this.help != null) {

            if (this.function != null && this.key != null) {
                System.out.println("You have entered a command with a function to either encrypt or decrypt with a key. The key must be shorter than the input text to be encrypted or decrypted.");
            }
            else if (this.function != null) {
                System.out.println(
                        "You may choose to either 'encrypt' or 'decrypt' a message with the Vegenere Cipher. This cipher will require a key which you will be promted to enter later if you did not specify at the main command line.");
            }
            else {
                System.out.println(
                        "Vegenere Cipher will ask you to encrypt or decrypt and will require a key, the key must contain only letters. Uppercase or lowercase does not matter. The key must also be less characters than the input text to be encrypted or decrypted");
            }
        }

        else if (this.about != null) {
            System.out.println("\n"
                    + "First described in 1553, the cipher is easy to understand and implement, but it resisted all attempts to break it for three centuries until 1863. This earned it the description le chiffre indéchiffrable (French for 'the indecipherable cipher'). Many people have tried to implement encryption schemes that are essentially Vigenère ciphers.[3] In 1863, Friedrich Kasiski was the first to publish a general method of deciphering Vigenère ciphers."
                    + "\n" + "\n" +

                    "The Vigenère cipher was originally described by Giovan Battista Bellaso in his 1553 book La cifra del. Sig. Giovan Battista Bellaso, but the scheme was later misattributed to Blaise de Vigenère (1523–1596) in the 19th century and so acquired its present name. "
                    + "(\"Vegenere cipher,\" n.d.)");
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

            if (this.function.equalsIgnoreCase("encrypt")) {
                Printables.createPrintout(inputText, function, null, encryptText(inputText), key);

            }

            else if (this.function.equalsIgnoreCase("decrypt")) {
                Printables.createPrintout(inputText, function, null, decryptText(inputText), key);

            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    /*
     * steps needed for encryption 1. take the key and add text to it to make it the
     * same length as the input text. 2. key char 0 = x, input char 0 = y. Key
     * equals colums, input equals rows. encrypted char 0 = tabulaRecta[y][x].
     */

    public String encryptText(String input) {

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyExtended = keyUC;
        int counter = 0;

        // Makes the key repeat itself until the length of input.

        for (int i = 0; i < input.length() - keyUC.length(); i++) {

            if (keyUC.length() < input.length()) {

                keyExtended += Character.toString(keyUC.charAt(counter));
                counter++;

                if (counter == keyUC.length()) {

                    counter = 0;
                }
            }
        }

        char[] keyPlusInputArray = keyExtended.toCharArray();
        char[] inputArray = inputUC.toCharArray();
        char[] output = new char[inputUC.length()];

        for (int i = 0; i < input.length(); i++) {

            int indexKey = alphabet.indexOf(keyPlusInputArray[i]);
            int indexInput = alphabet.indexOf(inputArray[i]);

            output[i] = this.tabulaRecta[indexInput][indexKey];
        }

        return String.valueOf(output);
    }

    /*
     * Steps below to decrypt Vegenere Cipher. 1. Change input and key to upper
     * case. 2. nested for loop finds the row for key and sends that entire row to a
     * string. 3. for loops finds the index number of the encrypted char in that
     * rowString. 4. Output[i] is the index of that char in the row in the
     * alphabet(or the column number).
     */

    public String decryptText(String input) {

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyExtended = keyUC;
        int counter = 0;

        // Makes the key repeat itself until the length of input.

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

        for (int i = 0; i < inputUC.length(); i++) {

            String rowString = "";

            for (int j = 0; j < 26; j++) {

                rowString = rowString + tabulaRecta[alphabet.indexOf(keyExtended.charAt(i))][j];
            }

            output[i] = alphabet.charAt(rowString.indexOf(inputUC.charAt(i)));
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
