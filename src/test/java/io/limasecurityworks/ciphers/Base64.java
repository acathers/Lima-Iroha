package io.limasecurityworks.ciphers;

import java.util.HashMap;

public class Base64 {

    private String function;
    private String help;
    private String about;
    private String string64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy0123456789+/";

    /*
    *
    * int i = 13;
    * short s = 13;
    * byte b = 13;
    *
    * System.out.println("i: " + String.format("%32s",  //%32s means it will be padded to the left if < 32 chars.
    *         Integer.toBinaryString(i)).replaceAll(" ", "0"));  // replace all makes space padding 0s
    * System.out.println("s: " + String.format("%16s", 
    *         Integer.toBinaryString(0xFFFF & s)).replaceAll(" ", "0"));
    * System.out.println("b: " + String.format("%8s", 
    *        Integer.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0"));
    */

    /*
    * Once the input text is made into binary, this HashMap is used to change the binary to character.
    */

    private HashMap<String, String> encryptionMap = new HashMap<String, String>(26, 1); {{

        for (int i = 0; i < 64; i++) {

            encryptionMap.put(Integer.toBinaryString(i), Character.toString(string64.charAt(i)));
        }
    }}    

        System.out.println("b: " + String.format("%8s", Integer.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0"));


        String str = "CC%";
        String result = "";
        char[] messChar = str.toCharArray();

        for (int i = 0; i < messChar.length; i++) {
            result += Integer.toBinaryString(messChar[i]) + " ";
        }

        System.out.println(result);

    public Base64(String function, String help, String about) {

        this.function = function;
        this.help = help;
        this.about = about;
    }

    public void runBase64() {

    }

    public String encryptText(String input) {
        
        String output = "";
        String inputBinary = "";
        int counter = 0;
        String index = "";

        for (int i = 0; i < input.length(); i++){

            inputBinary += Integer.toBinaryString(input.charAt(i));
        }

        for (int i = 0; i < inputBinary.length(); i++) {

            index += Character.toString(inputBinary.charAt(i));
            counter++;

            if (counter == 6) {

                output += encryptionMap.get(index);
                counter = 0;
            }

            if (i == inputBinary.length() - 1) {

                if (counter == 2) {

                    output += "==";
                }
                else if (counter == 4) {

                    output += "=";
                }
            }
        }

        return output;
    }

    public String decryptText(String input) {

        String output = "";

        return output;
    }
}