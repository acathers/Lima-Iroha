package io.limasecurityworks.ciphers;

import java.util.HashMap;

import io.limasecurityworks.printables.Printables;
import io.limasecurityworks.processes.*;

public class Base64 {

    private String function;
    private String help;
    private String about;
    private String string64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    private HashMap<String, String> encryptionMap = new HashMap<String, String>(26, 1);
    {
        {

            for (int i = 0; i < 64; i++) {

                encryptionMap.put(String.format("%6s", Integer.toBinaryString(i)).replace(' ', '0'), Character.toString(string64.charAt(i)));
            }
        }
    }

    private HashMap<String, String> decryptionMap = new HashMap<String, String>(64, 1);
    {
        {

            for (int i = 0; i < 64; i++) {

                decryptionMap.put(Character.toString(string64.charAt(i)), String.format("%6s", Integer.toBinaryString(i)).replace(' ', '0'));
            }
        }
    }

    public Base64(String function, String help, String about) {
        this.function = function;
        this.help = help;
        this.about = about;
    }

    public void runBase64() {

        if (this.help != null) {

            if (this.function != null) {
                System.out.println(
                        "You have entered a command with a function to either encrypt or decrypt. There are no keys for the Base64 Cipher. You will next be prompted to input your text to be encrypted or decrypted after this command - help.");
            }
            else {
                System.out.println(
                        "Base64 Cipher will ask you if you would like to encrypt or decrypt and then it will ask for input. There is not a key to be input for this cipher. You will first be prompted to specify if you would like to encrypt or decrypt after entering this command - help.");
            }
        }

        else if (this.about != null) {
            System.out.println(
                    "Base64 is a group of similar binary-to-text encoding schemes that represent binary data in an ASCII string format by translating it into a radix-64 representation. The term Base64 originates from a specific MIME content transfer encoding. Each Base64 digit represents exactly 6 bits of data. Three 8-bit bytes (i.e., a total of 24 bits) can therefore be represented by four 6-bit Base64 digits."
                            + " " + "(\"Autokey cipher,\" n.d.)");
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
                
                Printables.createPrintout(inputText, function, null, encryptText(inputText));

            }

            else if (this.function.equalsIgnoreCase("decrypt")) {
                Printables.createPrintout(inputText, function, null, encryptText(inputText));
            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    public String encryptText(String input) {

        String output = "";
        String inputBinary = "";
        int counter = 0;
        String index = "";

        for (int i = 0; i < input.length(); i++) {

            inputBinary += String.format("%8s", Integer.toBinaryString(input.charAt(i))).replace(' ', '0');
        }

        for (int i = 0; i < inputBinary.length(); i++) {

            index += Character.toString(inputBinary.charAt(i));
            counter++;

            if (counter == 6) {

                output += encryptionMap.get(index);
                counter = 0;
                index = "";
            }

            if (i == inputBinary.length() - 1) {

                if (counter == 2) {

                    index += "0000";
                    output += encryptionMap.get(index);
                    output += "==";
                }

                else if (counter == 4) {

                    index += "00";
                    output += encryptionMap.get(index);
                    output += "=";
                }
            }
        }
        return output;
    }

    /*
     * Steps to decryption of a base64 string. 1. Turn the string into binary using
     * hashmap. Each letter will produce 6 digits. 2. Convert the binary string back
     * to letters using 8 digits per character.
     */

    public String decryptText(String input) {

        String index = "";
        String output = "";
        int counter = 0;
        int padding = 0;
        String binaryString = "";

        if (input.charAt(input.length() - 1) == 61) {

            padding = 1;

            if (input.charAt(input.length() - 2) == 61) {

                padding = 2;
            }

            input = input.replace("=", "");
        }

        for (int i = 0; i < input.length(); i++) {

            binaryString += decryptionMap.get(Character.toString(input.charAt(i)));
        }

        for (int i = 0; i < binaryString.length() - (padding * 2); i++) {

            index += Character.toString(binaryString.charAt(i));
            counter++;

            if (counter == 8) {

                int parseInt = Integer.parseInt(index, 2);
                char c = (char) parseInt;

                output += Character.toString(c);
                index = "";
                counter = 0;
            }
        }
        return output;
    }
}