package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;
import java.lang.Math;
import java.util.Arrays;
import io.limasecurityworks.processes.*;
import io.limasecurityworks.tools.*;
import io.limasecurityworks.tools.StringBoolean;

public class ADFGVX {

    private String function;
    private String key;
    private String keySquare;
    private String help;
    private String about;

    final static String lettersDigits = "abcdefghijklmnopqrstuvwxyz1234567890";

    private String[] keySquareOutput = {"AA", "AD", "AF", "AG", "AV", "AX", "DA", "DD", "DF", "DG", "DV", "DX", "FA", "FD", "FF", "FG", "FV", "FX", "GA", "GD", "GF", "GG", "GV", "GX", "VA", "VD", "VF", "VG", "VV", "VX", "XA", "XD", "XF", "XG", "XV", "XX"};


    public ADFGVX(String function, String key, String keySquare, String help, String about) {
        this.function = function;
        this.key = key;
        this.keySquare = keySquare;
        this.help = help;
        this.about = about;
    }

    public void runAVC() {

        //First check if the command requests help and act on in appropriately.

        if (help != null) {
            if (function != null && key != null) {
                System.out.println("\n" + "You have entered a command for ADFVGX Cipher with a function and a key. The only two options for a function is to encrypt or decrypt. The key is only one part of the encryption. The key square is sort of a second key that is equally important.");
            }
            else if (function != null) {
                System.out.println("\n" + "You have entered a command for ADFVGX Cipher to encrypt or decrypt a message. Since you did not specify a key, you will be prompted to do so if this same command is typed without being followed by the help command. Messages are only allowed to have the alphabet and numbers 0 through 9.");
            }
            else {
                System.out.println("\n" + "The ADFGVX cipher requires a key and a key square which is means that it needs two keys, however the key square must contain all letters of the alphabet once and each number, 0 through 9 once for a total of 36 characters. The order of the characters is what is used for the key square. Your key is just as important in the encryption and decryption process. Just know that you MUST remember both the key and the key square. You are prompted to either use the default key square that the program provides, generate a new one, or to use a custom key square at the first.");
            }
        }

        else if (about != null) {
            System.out.println("\n" + "In cryptography, the ADFGVX cipher was a field cipher used by the German Army on the Western Front during World War I. ADFGVX was in fact an extension of an earlier cipher called ADFGX. Invented by Lieutenant[1] Fritz Nebel (1891–1977)[2] and introduced in March 1918, the cipher was a fractionating transposition cipher which combined a modified Polybius square with a single columnar transposition. The cipher is named after the six possible letters used in the ciphertext: A, D, F, G, V and X. The letters were chosen deliberately because they are very different from one another in the Morse code. That reduced the possibility of operator error. Nebel designed the cipher to provide an army on the move with encryption that was more convenient than trench codes but was still secure. In fact, the Germans believed the ADFGVX cipher was unbreakable." + "\n" + "\n" + "--Source: https://en.wikipedia.org/wiki/ADFGVX_cipher");
        }

        //Next, check to see if a function was provided. if not, get the function.

        else if (function == null) {
            function = Function.getFunction();
        }

        //If there is a fuction and the function is not valid, get a new function.

        else if (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")) {
            function = Function.checkFunction(function);
        }

        // Determine what keysquare will be used. if new, generate new, and if custom, allow input


        if (this.help == null && this.about == null) {

            boolean option = false;

            System.out.println();
            System.out.print("Key Square - Default, new, or custom?: ");

            String keySqOption = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (option == false) {

                if (keySqOption.equalsIgnoreCase("default")) {
                    keySquare = "avjzt7n5iwgm8u0q9dhb2rfcxyke4s13p6ol";
                    option = true;
                }
                else if (keySqOption.equalsIgnoreCase("new")) {
                    generateKeySquare();
                    System.out.println();
                    System.out.println(this.keySquare);
                    option = true;
                }
                else if (keySqOption.equalsIgnoreCase("custom")) {

                    boolean keySqReq = false;

                    restart:
                    while (keySqReq == false) {

                        StringBuilder lettersDigitsSB = new StringBuilder(lettersDigits);

                        System.out.println();
                        System.out.print("Input custom key square: ");

                        String customKeySq = io.limasecurityworks.ui.Iroha.sc.nextLine();

                        int counter = 36;

                        if (customKeySq.length() == 36) {
                            for (int i = 0; i < 36; i++) {
                                if (!Character.isLetter(customKeySq.charAt(i)) && !Character.isDigit(customKeySq.charAt(i))) {
                                    System.out.println("\n" + "The key square can contain only numbers and letters and must contain all letters of the alphabet and numbers 0-9");

                                    break restart;
                                }
                                else {
                                    for (int j = 0; j < counter; j++) {
                                        if (Character.toString(customKeySq.charAt(i)).equalsIgnoreCase(Character.toString(lettersDigitsSB.charAt(j)))) {

                                            lettersDigitsSB.deleteCharAt(j);
                                            counter--;
                                            if (lettersDigitsSB.length() == 0) {
                                                this.keySquare = customKeySq;
                                                keySqReq = true;
                                                option = true;
                                            }
                                        }
                                    }
                                    if (lettersDigitsSB.length() != 0 && i == 35) {
                                        System.out.println("\n" + "Something went wrong, your key square may have had duplicate letters or numbers.");
                                    }
                                }
                            }
                        }
                        else {
                            System.out.println("\n" + "Key square length must be 36 characters and contain numbers 0-9 and each letter of the alphabet.");
                        }
                    }
                }
                else {
                    System.out.print("\n" + "Invalid Command, please enter default, new or custom: ");

                    keySqOption = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }
            }
        }


        // Get input text and complete the encryption or decryption. ccHelp == null in the if statement is necessary to prevent it from running after a help command is entered.

        if (help == null && about == null) {
            System.out.println();
            System.out.print("Input Text: ");

            //This is where text to be encrypted or decrypted is put in.

            String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

            // if statment that uses the variables ccFunction and ccKey to determine what to do to the text.

            if (this.key == null) {
                System.out.print("Enter key: ");
                setKey(io.limasecurityworks.ui.Iroha.sc.nextLine());

            }

            if (this.function.equalsIgnoreCase("encrypt")) {
                System.out.println();
                System.out.println("Encrypted Text:  " + encryptText(input));
                System.out.println("Key Square:      " + this.keySquare);
                System.out.println("Key:             " + this.key);
            }
            else if (this.function.equalsIgnoreCase("decrypt")) {
                System.out.println();
                System.out.println("Decrypted Text:  " + decryptText(input));
                System.out.println("Key Square:      " + this.keySquare);
                System.out.println("Key:             " + this.key);
            }
            else if (this.function.equalsIgnoreCase("help")) {
                System.out.println("You should get help, but I have yet to develop help for this part of the program at this time.");
            }
            else {
                System.out.println(encryptText("Would you like to encrypt or decrypt a message?"));
            }
        }
    }

    public void setKeySquare(String input) {

        if (input.length() == 36) {
            this.keySquare = input;
        }

    }

    public void setKey(String inputKey) {
        this.key = inputKey;
    }

    public String generateKeySquare() {

        String charLibrary = "abcdefghijklmnopqrstuvwxyz1234567890";
        int max = 36;
        int min = 0;
        StringBuilder charLibrarySB = new StringBuilder(charLibrary);
        StringBuilder newKeySquare = new StringBuilder();

            for (int i = 0; i <= 35; i++) {
                int random = (int)(Math.random() * max - min);
                char nextChar = charLibrarySB.charAt(random);
                newKeySquare.append(nextChar);
                charLibrarySB.deleteCharAt(random);
                max--;
            }
        return this.keySquare = newKeySquare.toString();
    }

    //Checks the keysquare to ensure it contains every letter and digit once.
    public static boolean checkKeySquare(String input) {

        boolean complete = false;

        StringBuilder lettersDigitsSB = new StringBuilder(lettersDigits);
        int counter = 36;

        if (input.length() == 36) {
            for (int i = 0; i < 36; i++) {
                if (!StringBoolean.isAlpha(Character.toString(input.charAt(i))) && !Character.isDigit(input.charAt(i))) {
                    break;
                }
                else {
                    for (int j = 0; j < counter; j++) {
                        if (Character.toString(input.charAt(i)).equalsIgnoreCase(Character.toString(lettersDigitsSB.charAt(j)))) {

                            lettersDigitsSB.deleteCharAt(j);
                            counter--;
                            if (lettersDigitsSB.length() == 0) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return complete;
    }

    public static String cleanInput(String input) {

        return ReChars.reAllNonLetters(input);
    }

    public static boolean checkKey(String input) {

        return StringBoolean.isAlpha(input);
    }



    /*
    * Method used to encrypt a message. This method uses the following steps.
    * 1. Takes input and fractionates it.
    * 2. Split up the fractionated input. There will be a number of columns equal to the number
    * of characters in the key. Characters of the frationated input are dealt to the columns as
    * first char to first letter of key, second char to second letter of key, and so forth until
    * there are no more letters in key, then it starts again at first letter of key and repeats
    * until there are no chars left in fractionated input.
    * 3. Now the keyword needs to be alphabetized and the column of chars that each character of
    * the keyword got needs to move with it and then send each column of the new alphabetized order
    * to a string with no spaces starting with the first alphabetized keyword to the last.
    */


    public String encryptText(String input) {

        /*
        * STEP 1
        *
        * Takes text to be encrypted and fractionates it using keySquare.
        */
        StringBuilder keySquareSB = new StringBuilder(this.keySquare);
        StringBuilder fractionatedInput = new StringBuilder();
        String inputLC = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            String currentChar = Character.toString(inputLC.charAt(i));
            if (Character.isLetter(currentChar.charAt(0)) || Character.isDigit(currentChar.charAt(0))) {
                fractionatedInput.append(this.keySquareOutput[keySquareSB.indexOf(currentChar)]);
            }
        }

        /*
        * STEP 2
        *
        * Split up franctionated string into an array. Each element of the array is a column which
        * will later need to be alphabetized in order to complete the encryption. Row 1 gets the
        * key, row 2 gets the fractionalized string.
        */

        StringBuilder[][] fractInputCT = new StringBuilder[2][this.key.length()];

        for (int i = 0; i < this.key.length(); i++) {
            fractInputCT[0][i] = new StringBuilder(Character.toString(this.key.charAt(i)));
        }

        //This deals the chars of the fractionated input to the array places.

        int charPlaceMarker = 0;

        while (charPlaceMarker < fractionatedInput.length()) {
            for (int i = 0; i < this.key.length() && charPlaceMarker < fractionatedInput.length(); i++) {
                if (fractInputCT[1][i] == null) {
                    fractInputCT[1][i] = new StringBuilder(Character.toString(fractionatedInput.charAt(charPlaceMarker)));

                    charPlaceMarker++;
                }
                else {
                    fractInputCT[1][i].append(Character.toString(fractionatedInput.charAt(charPlaceMarker)));

                    charPlaceMarker++;
                }
            }
        }

        /*
        * STEP 3
        *
        * This section now takes the key and sends it to a char array and then sorts it and sends
        * it back to a String. The while loop then finds the first char in the key that matches the
        * first char in the sorted key and sends that char's encrypted text to a string.
        */

        char[] charAlpha = this.key.toCharArray();
        Arrays.sort(charAlpha);
        String sortedKey = new String(charAlpha);

        int sortedKeyPlace = 0;

        StringBuilder outputSB = new StringBuilder();

        while (outputSB.length() < fractionatedInput.length()) {

            for (int i = 0; i < this.key.length(); i++) {
                String testChar = Character.toString(this.key.charAt(i));
                String testCharAlpha = Character.toString(sortedKey.charAt(sortedKeyPlace));
                if (testChar.equalsIgnoreCase(testCharAlpha) && fractInputCT[1][i] != null) {

                    outputSB.append(fractInputCT[1][i]);
                    sortedKeyPlace++;
                    fractInputCT[1][i] = null;
                    break;
                }
            }
        }

        return outputSB.toString();
    }

    // Now to decrypt encrypted message.

    public String decryptText(String input) {

        // New array to hold the encrypted columns. Need to fill this array with the right number of columns.

        StringBuilder inputSB = new StringBuilder(input);
        StringBuilder[][] fractInputCTD = new StringBuilder[2][this.key.length()];

        // By deviding the input length by the number of keys, we find out how many columns will have an extra character by the value of the remainder. We will call this value modulus.

        int modulus = inputSB.length() % key.length();

        // By dividing the length of the input by the key, without a remainder, we find out how many chars a non modulus column will have.

        int columnLength = inputSB.length() / key.length();


        // maker to show what place we are in with our encrypted text string.

        int charPlaceMarkerD = 0;

        // The for loop will add the characters of the key that will contain an extra letter. The letters of the key that will contain an extra letter are the first ones. If modulus is 2, then the first two characters of the key will have an extra letter.

        StringBuilder modulusChars = new StringBuilder();

        for (int i = 0; i < modulus; i++) {
            modulusChars.append(this.key.charAt(i));
        }

        // Sort the key alphabetically into variable named "sortedKey".

        char[] charAlpha = this.key.toCharArray();
        Arrays.sort(charAlpha);
        String sortedKey = new String(charAlpha);

        // This for loop will fill each letter of the key with the letters from the encrypted text.

        for (int i = 0; i < this.key.length(); i++) {

            // This for loop runs if the character of the key is a modulus.


            if (modulusChars.indexOf(Character.toString(sortedKey.charAt(i))) != -1) {

                // Remove the modulusChar so as to not be reused.

                modulusChars.deleteCharAt(modulusChars.indexOf(Character.toString(sortedKey.charAt(i))));

                for (int j = 0; j < columnLength + 1; j++) {
                    if (fractInputCTD[1][i] == null) {
                        fractInputCTD[1][i] = new StringBuilder(Character.toString(inputSB.charAt(charPlaceMarkerD)));
                        charPlaceMarkerD++;
                    }
                    else {
                        fractInputCTD[1][i].append(inputSB.charAt(charPlaceMarkerD));
                        charPlaceMarkerD++;
                    }
                }
            }

            // If not a modulusChars

            else {
                for (int k = 0; k < columnLength; k++) {
                    if (fractInputCTD[1][i] == null) {
                        fractInputCTD[1][i] = new StringBuilder(Character.toString(inputSB.charAt(charPlaceMarkerD)));
                        charPlaceMarkerD++;
                    }
                    else {
                        fractInputCTD[1][i].append(inputSB.charAt(charPlaceMarkerD));
                        charPlaceMarkerD++;
                    }
                }
            }
        }

        // Now move columns out of alphabetical order to the key.

        StringBuilder[][] fractInputCTDAlpha = new StringBuilder[2][this.key.length()];

        for (int i = 0; i < this.key.length(); i++) {
            fractInputCTDAlpha[1][i] = new StringBuilder(fractInputCTD[1][sortedKey.indexOf(Character.toString(this.key.charAt(i)))]);
        }

        //got columns in the array in the alphabetized places

        StringBuilder outputSBD = new StringBuilder("");
        charPlaceMarkerD = 0;
        int forLength;

        if (input.length() % this.key.length() > 0) {
            forLength = input.length() / this.key.length() + 1;
        }

        else {
            forLength = input.length() / this.key.length();
        }

        while (outputSBD.length() < input.length()) {

            for (int i = 0; i < forLength; i++) {
                for (int j = 0; j < this.key.length(); j++) {
                    if(fractInputCTDAlpha[1][j].length()  > i) {
                        outputSBD.append(Character.toString(fractInputCTDAlpha[1][j].charAt(i)));
                    }
                }
            }
        }

        //outputSBD now contains fractionated message that needs unfractionated.

        StringBuilder currentCharD = new StringBuilder();
        StringBuilder outputSBDU = new StringBuilder("");

        for (int i = 0; i < outputSBD.length(); i += 2) {

            currentCharD = new StringBuilder(Character.toString(outputSBD.charAt(i)));
            currentCharD.append(Character.toString(outputSBD.charAt(i + 1)));
            String currentCharDS = currentCharD.toString();

            for (int j = 0; j < 36; j++) {
                if (currentCharDS.equalsIgnoreCase(this.keySquareOutput[j])) {
                    outputSBDU.append(this.keySquare.charAt(j));
                    break;
                }
            }
        currentCharD = null;
        }

        return outputSBDU.toString();
    }
}
