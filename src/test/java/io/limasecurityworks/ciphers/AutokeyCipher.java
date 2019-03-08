package io.limasecurityworks.ciphers;

public class AutokeyCipher {

    private String function;
    private String key;
    private String help;
    private String about;

    private char tabulaRecta[][] = {{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A'}, {'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'}, {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'}, {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'}, {'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E'}, {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F'}, {'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}, {'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}, {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}, {'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'}, {'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'}, {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'}, {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'}, {'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'}, {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'}, {'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'}, {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'}, {'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'}, {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'}, {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'}, {'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'}, {'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'}, {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'}, {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'}};

    public AutokeyCipher(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    public void runAutokey() {

        if (this.help != null) {

            if (this.function != null && this.key != null) {
                System.out.println("You have entered a command with a function to either encrypt or decrypt with a key. The key must be shorter than the input text to be encrypted or decrypted.");
            }
            else if (this.function != null) {
                System.out.println("You may choose to either 'encrypt' or 'decrypt' a message with the Autokey Cipher. This cipher will require a key which you will be promted to enter later if you did not specify at the main command line.");
            }
            else {
                System.out.println("Autokey Cipher will ask you to encrypt or decrypt and will require a key, the key must contain only letters. Uppercase or lowercase does not matter. The key must also be less characters than the input text to be encrypted or decrypted");
            }
        }

        else if (this.about != null) {
            System.out.println("This cipher was invented in 1586 by Blaise de Vigenère with a reciprocal table of ten alphabets. Vigenère's version used an agreed-upon letter of the alphabet as a primer, making the key by writing down that letter and then the rest of the message. " + "\n" + "\n" +

            "More popular autokeys use a tabula recta, a square with 26 copies of the alphabet, the first line starting with 'A', the next line starting with 'B' etc. Instead of a single letter, a short agreed-on keyword is used, and the key is generated by writing down the primer and then the rest of the message, as in Vigenère's version. To encrypt a plaintext, the row with the first letter of the message and the column with the first letter of the key are located. The letter in which the row and the column cross is the ciphertext letter. " +"(\"Autokey cipher,\" n.d.) " + "\n" + "\n" +

            "This program uses the more pupular version which uses the tabula recta and allows full words as a key.");
        }

        else {

            // Find out if there is a function, if not, get it.

            if (this.function == null) {

                System.out.print("Would you like to encrypt or decrypt?: ");

                String functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();

                while (!functionChoice.equalsIgnoreCase("encrypt") && !functionChoice.equalsIgnoreCase("decrypt")) {

                    System.out.print("\n" + "Invalid command for function, use either encrypt or decrypt: ");

                    functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }

                this.function = functionChoice;
            }

            // Find out if key have been suplemented, if not, get them.

            if (this.key == null) {

                System.out.print("Input key: ");

                this.key = io.limasecurityworks.ui.Iroha.sc.nextLine();

                while (!isAlpha(this.key)) {

                    System.out.println("The key must contain only letters and it must be shorter than the text to be encrypted. Enter key: ");

                    this.key = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }

            }

            // Get input text and execute cipher.

            System.out.print("Input text: ");

            String inputText = io.limasecurityworks.ui.Iroha.sc.nextLine();

            if (this.function.equalsIgnoreCase("encrypt")) {

                String encryptedText = encryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key:      " + this.key + "\n" + "Key:      " + "\n" + "Input:    " + inputText + "\n" + "Output:   " + encryptedText);
            }

            else if (this.function.equalsIgnoreCase("decrypt")) {

                String decryptedText = decryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key:      " + this.key + "\n" + "Key:      " + "\n" + "Input:    " + inputText + "\n" + "Output:   " + decryptedText);
            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    /*
    *
    * steps needed for encryption
    * 1. take the key and add text to it to make it the same length as the input text.
    * 2. key char 0 = x, input char 0 = y. Key equals colums, input equals rows.
    *    encrypted char 0 = tabulaRecta[y][x].
    */

    public String encryptText(String input) {

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();

        String keyPlusInputUC = keyUC + inputUC.substring(0, (inputUC.length() - keyUC.length() - 1));
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] keyPlusInputArray = keyPlusInputUC.toCharArray();
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
    *
    * Steps below to decrypt Autokey Cipher.
    * 1. Change input and key to upper case.
    * 2. nested for loop finds the row for key and sends that entire row to a string.
    * 3. for loops finds the index number of the encrypted char in that rowString.
    * 4. Output[i] is the index of that char in the row in the alphabet(or the column number).
    */

    public String decryptText(String input) {

        String inputUC = input.toUpperCase();
        String keyUC = this.key.toUpperCase();

        String keyPlusDecryptText = keyUC;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] output = new char[inputUC.length()];

        for (int i = 0; i < inputUC.length(); i++) {

            String rowString = "";

            for (int j = 0; j < 26; j++) {

                rowString = rowString + tabulaRecta[alphabet.indexOf(keyUC.charAt(i))][j];
            }

            output[i] = alphabet.charAt(rowString.indexOf(inputUC.charAt(i)));
            keyUC = keyUC + alphabet.charAt(rowString.indexOf(inputUC.charAt(i)));
        }

        return String.valueOf(output);
    }

    public boolean isAlpha(String input) {
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
