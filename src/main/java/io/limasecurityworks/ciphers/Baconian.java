package io.limasecurityworks.ciphers;

import java.util.HashMap;
import io.limasecurityworks.processes.*;

public class Baconian {

    private String function;
    private String help;
    private String about;

    private HashMap<Character, String> encryptionMap = new HashMap<Character, String>(26, 1);
    {
        {

            encryptionMap.put('A', "00000");
            encryptionMap.put('B', "00001");
            encryptionMap.put('C', "00010");
            encryptionMap.put('D', "00011");
            encryptionMap.put('E', "00100");
            encryptionMap.put('F', "00101");
            encryptionMap.put('G', "00110");
            encryptionMap.put('H', "00111");
            encryptionMap.put('I', "01000");
            encryptionMap.put('J', "01001");
            encryptionMap.put('K', "01010");
            encryptionMap.put('L', "01011");
            encryptionMap.put('M', "01100");
            encryptionMap.put('N', "01101");
            encryptionMap.put('O', "01110");
            encryptionMap.put('P', "01111");
            encryptionMap.put('Q', "10000");
            encryptionMap.put('R', "10001");
            encryptionMap.put('S', "10010");
            encryptionMap.put('T', "10011");
            encryptionMap.put('U', "10100");
            encryptionMap.put('V', "10101");
            encryptionMap.put('W', "10110");
            encryptionMap.put('X', "10111");
            encryptionMap.put('Y', "11000");
            encryptionMap.put('Z', "11001");
        }
    }

    private HashMap<String, String> decryptionMap = new HashMap<String, String>(26, 1);
    {
        {

            decryptionMap.put("00000", "A");
            decryptionMap.put("00001", "B");
            decryptionMap.put("00010", "C");
            decryptionMap.put("00011", "D");
            decryptionMap.put("00100", "E");
            decryptionMap.put("00101", "F");
            decryptionMap.put("00110", "G");
            decryptionMap.put("00111", "H");
            decryptionMap.put("01000", "I");
            decryptionMap.put("01001", "J");
            decryptionMap.put("01010", "K");
            decryptionMap.put("01011", "L");
            decryptionMap.put("01100", "M");
            decryptionMap.put("01101", "N");
            decryptionMap.put("01110", "O");
            decryptionMap.put("01111", "P");
            decryptionMap.put("10000", "Q");
            decryptionMap.put("10001", "R");
            decryptionMap.put("10010", "S");
            decryptionMap.put("10011", "T");
            decryptionMap.put("10100", "U");
            decryptionMap.put("10101", "V");
            decryptionMap.put("10110", "W");
            decryptionMap.put("10111", "X");
            decryptionMap.put("11000", "Y");
            decryptionMap.put("11001", "Z");
        }
    }

    public Baconian(String function, String help, String about) {
        this.function = function;
        this.help = help;
        this.about = about;
    }

    public void runBaconian() {

        if (this.help != null) {

            if (this.function != null) {
                System.out.println(
                        "You have entered a command with a function to either encrypt or decrypt. There are no keys for the Baconian Cipher at this time. The translation of a letter to 1s and 0s can be found on the wikipedia page for Baconian Cipher. May add a feature to change that up in the future.");
            }
            else {
                System.out.println(
                        "Baconian Cipher will ask you if you would like to encrypt or decrypt and then it will ask for input. There is not a key to be input for this cipher. The translation of a letter to 1s and 0s can be found on the wikipedia page for Baconian Cipher. May add a feature to change that up in the future.");
            }
        }

        else if (this.about != null) {
            System.out.println("Bacon’s cipher or the Baconian cipher is a method of steganography (a method of hiding a secret message as opposed to just a cipher) devised by Francis Bacon in 1605. Geeks for Geeks. Baconian Cipher.");
        }

        else {

            // Find out if there is a function, if not, get it.

            if (this.function == null) {
                function = Function.getFunction();
            }

            // Get input text and execute cipher.

            System.out.print("Input text: ");

            String inputText = io.limasecurityworks.ui.Iroha.sc.nextLine();

            if (this.function.equalsIgnoreCase("encrypt")) {

                String encryptedText = encryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Input:    " + inputText + "\n" + "Output:   " + encryptedText);
            }

            else if (this.function.equalsIgnoreCase("decrypt")) {

                String decryptedText = decryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Input:    " + inputText + "\n" + "Output:   " + decryptedText);
            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    /*
     * This encryption method will take in any string, remove any non letters, and
     * complete the encryption.
     */

    public String encryptText(String input) {

        input = input.toUpperCase();

        int counter = 0;

        char[] inputArray = input.toCharArray();
        char[] inputLetters = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {

            if (Character.isLetter(inputArray[i])) {

                inputLetters[counter] = inputArray[i];

                counter++;
            }
        }

        String output = "";

        for (int i = 0; i < counter; i++) {

            output = output + encryptionMap.get(inputLetters[i]);
        }
        return output;
    }

    public String decryptText(String input) {

        String indexValue = "";
        String output = "";

        char[] inputArray = input.toCharArray();

        int counter = 0;

        for (int i = 0; i < input.length(); i++) {

            indexValue = indexValue + inputArray[i];

            counter++;

            if (counter == 5) {

                output = output + decryptionMap.get(indexValue);

                indexValue = "";
                counter = 0;
            }
        }
        return output;
    }
}
