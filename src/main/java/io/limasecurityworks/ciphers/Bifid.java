package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;
import java.lang.Math;
import java.util.HashMap;
import io.limasecurityworks.tools.*;
import io.limasecurityworks.printables.*;
import io.limasecurityworks.processes.*;

public class Bifid {

    private String function;
    private String key;
    private String keySquare = "avztniwgmuqdhbrfcxykespol";
    private String help;
    private String about;

    private String[] keySquareOutput = { "11", "12", "13", "14", "15", "21", "22", "23", "24", "25", "31", "32", "33",
            "34", "35", "41", "42", "43", "44", "45", "51", "52", "53", "54", "55" };

    public Bifid(String function, String key, String help, String about) {
        this.function = function;
        this.key = key;
        this.help = help;
        this.about = about;
    }

    public void runBifid() {

        // First check if the command requests help and act on in appropriately.

        if (help != null) {
            if (function != null && key != null) {
                System.out.println("\n"
                        + "You have entered a command for Bifid Cipher with a function and a key. The only two options for a function is to encrypt or decrypt. The key is only one part of the encryption. The key square is like a second key that is equally important.");
            } else if (function != null) {
                System.out.println("\n"
                        + "You have entered a command for Bifid Cipher to encrypt or decrypt a message. Since you did not specify a key, you will be prompted to do so if this same command is typed without being followed by the help command. Messages are only allowed have letters.");
            } else {
                System.out.println("\n"
                        + "The Bifid cipher requires a key and a key square which is means that it needs two keys, however the key square must contain all letters of the alphabet once except the letter 'j'. So you should have 25 characters. The order of the characters is what is used for the key square. Your key is just as important in the encryption and decryption process. Just know that you MUST remember both the key and the key square. You are prompted to either use the default key square that the program provides, generate a new one, or to use a custom key square at the first.");
            }
        }

        else if (about != null) {
            System.out.println("\n"
                    + "Bifid is a cipher which combines the Polybius square with transposition, and uses fractionation to achieve diffusion. It was invented by Felix Delastelle. Delastelle was a Frenchman who invented several ciphers including the bifid, trifid, and four-square ciphers. The first presentation of the bifid appeared in the French Revue du Génie civil in 1895 under the name of cryptographie nouvelle.");
        }

        // Next, check to see if a function was provided. if not, get the function.

        else if (function == null) {
            function = Function.getFunction();
        }

        // If there is a fuction and the function is not valid, get a new function.

        else if (!this.function.equalsIgnoreCase("encrypt") && !this.function.equalsIgnoreCase("decrypt")) {
            function = Function.checkFunction(function);
        }

        // This section will allow the user to use the default key square, generate a
        // new random keysquare, or use a custom key square.

        if (this.help == null && this.about == null) {
            boolean option = false;

            System.out.print("Key Square - Default, new, or custom?: ");

            String keySqOption = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (option == false) {

                if (keySqOption.equalsIgnoreCase("default")) {
                    option = true;
                } else if (keySqOption.equalsIgnoreCase("new")) {
                    generateKeySquare();
                    System.out.println();
                    System.out.println(this.keySquare);
                    option = true;
                } else if (keySqOption.equalsIgnoreCase("custom")) {

                    boolean keySqReq = false;

                    restart: while (keySqReq == false) {

                        String lettersDigits = "abcdefghiklmnopqrstuvwxyz";
                        StringBuilder lettersDigitsSB = new StringBuilder(lettersDigits);

                        System.out.println();
                        System.out.print("Input custom key square: ");

                        String customKeySq = io.limasecurityworks.ui.Iroha.sc.nextLine();

                        int counter = 25;

                        if (customKeySq.length() == 25) {

                            // Check to make sure that next character is a letter and not 'j'.

                            for (int i = 0; i < 25; i++) {

                                if (!Character.isLetter(customKeySq.charAt(i))
                                        || Character.toString(customKeySq.charAt(i)).equalsIgnoreCase("j")) {
                                    System.out.println("\n"
                                            + "The key square can contain only letters and must contain all letters of the alphabet once except for the letter 'j' for a total character count of 25");

                                    break restart;
                                }

                                else {
                                    for (int j = 0; j < counter; j++) {
                                        if (Character.toString(customKeySq.charAt(i))
                                                .equalsIgnoreCase(Character.toString(lettersDigitsSB.charAt(j)))) {

                                            lettersDigitsSB.deleteCharAt(j);
                                            counter--;
                                            if (lettersDigitsSB.length() == 0) {
                                                this.keySquare = customKeySq;
                                                keySqReq = true;
                                                option = true;
                                            }
                                        }
                                    }

                                    // Will display when duplicate letters.

                                    if (lettersDigitsSB.length() != 0 && i == 24) {
                                        System.out.println("\n"
                                                + "Something went wrong, your key square may have had duplicate letters.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("\n"
                                    + "Key square length must be 25 characters and contain each letter of the alphabet except 'j'.");
                        }
                    }
                } else {
                    System.out.print("\n" + "Invalid Command, please enter default, new or custom: ");

                    keySqOption = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }
            }
        }

        // Get input text and complete the encryption or decryption. ccHelp == null in
        // the if statement is necessary to prevent it from running after a help command
        // is entered.

        if (help == null && about == null) {
            System.out.print("Input Text: ");

            String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

            input = ReChars.reAllNonLetters(input);

            input = input.toLowerCase();

            input = RepChars.replaceCharacter(input, "j", "i");

            if (this.key == null) {
                System.out.print("Enter key: ");
                setKey(io.limasecurityworks.ui.Iroha.sc.nextLine());
            }

            if (this.function.equalsIgnoreCase("encrypt")) {
                Headers.translationHeader();
                System.out.print("Input:          " + input + "\n" + "Key Square:     " + keySquare + "\n"
                        + "Key:            " + key + "\n" + "Encrypted Text: " + encryptText(input) + "\n");
            } else if (this.function.equalsIgnoreCase("decrypt")) {
                Headers.translationHeader();
                System.out.print("Input:          " + input + "\n" + "Key Square:     " + keySquare + "\n"
                        + "Key:            " + key + "\n" + "Decrypted Text: " + decryptText(input) + "\n");
            } else if (this.function.equalsIgnoreCase("help")) {
                System.out.println(
                        "You should get help, but I have yet to develop help for this part of the program at this time.");
            } else {
                System.out.println(encryptText("Would you like to encrypt or decrypt a message?"));
            }
        }
    }

    public void setKeySquare(String input) {

        if (input.length() == 25) {
            this.keySquare = input;
        }
    }

    public void setKey(String inputKey) {
        this.key = inputKey;
    }

    public String generateKeySquare() {

        String charLibrary = "abcdefghiklmnopqrstuvwxyz";
        int max = 25;
        int min = 0;
        StringBuilder charLibrarySB = new StringBuilder(charLibrary);
        StringBuilder newKeySquare = new StringBuilder();

        for (int i = 0; i <= 24; i++) {
            int random = (int) (Math.random() * max - min);
            char nextChar = charLibrarySB.charAt(random);
            newKeySquare.append(nextChar);
            charLibrarySB.deleteCharAt(random);
            max--;
        }
        return this.keySquare = newKeySquare.toString();
    }

    public String toNumber(String input) {

        //Set up HashMaps toLetter and toNumber.

        HashMap<String, String> toNumber = new HashMap<String, String>(25, 1); {{

            for (int i = 0; i < 25; i++) {
    
                toNumber.put(Character.toString(keySquare.charAt(i)), keySquareOutput[i]);
            }
        }} 

        return toNumber.get(input);
    }

    public String toLetter(String input) {

        HashMap<String, String> toLetter = new HashMap<String, String>(25, 1); {{
    
            for (int i = 0; i < 25; i++) {
    
                toLetter.put(keySquareOutput[i], Character.toString(keySquare.charAt(i)));
            }
        }}

        return toLetter.get(input);
    }

    /*
     * Method used to encrypt a message. This method uses the following steps. 1.
     * Takes input and fractionates it. 2. Split the fractionated input into two
     * strings. 3. Use key to split up each of the two new strings into an array
     * with each index holding the key number of chars.
     */

    public String encryptText(String input) {

        String output = "";
        String numberOutput = "";
        String index = "";
        int counter = 0;
        int period = 0;
        int fullPeriodsPerArray = (input.length() * 2) / (Integer.parseInt(this.key) * 2);
        int periodsPerArray = fullPeriodsPerArray;

        // Determine if there will be a partial period at the end.

        if ((input.length() * 2) % (Integer.parseInt(this.key) * 2) > 0) {
            periodsPerArray += 1;
        }

        String[] periodArrayRow = new String[periodsPerArray];
        String[] periodArrayColumn = new String[periodsPerArray];

        for (int i = 0; i < periodsPerArray; i++) {

            periodArrayRow[i] = "";
            periodArrayColumn[i] = "";
        }

        // Change the input text to digits and assign them to apprpriate array.

        for (int i = 0; i < input.length(); i++) {

            // I am amused that I came up with this.

            periodArrayRow[period] += toNumber(Character.toString(input.charAt(i))).charAt(0);
            periodArrayColumn[period] += toNumber(Character.toString(input.charAt(i))).charAt(1);

            counter++;

            if (counter == Integer.parseInt(this.key)) {

                counter = 0;
                period++;
            }
        }

        // Produce one long string of digits.

        for (int i = 0; i < periodsPerArray; i++) {

            numberOutput += periodArrayRow[i];
            numberOutput += periodArrayColumn[i];
        }

        // Produce new encrypted text and return it.

        for (int i = 0; i < numberOutput.length(); i++) {

            index += Character.toString(numberOutput.charAt(i));

            if (index.length() == 2) {

                output += toLetter(index);

                index = "";
            }
        }
        return output;
    }

    /*
     * Decrypting a bifid cipher is the reverse of encryption.
     * 
     * Step 1: Convert text into a number string using the keysquare for each
     * letter. Step 2: Split the numbers into period length(key), row first, then
     * column, then row, so on and so forth. Step 3: Produce two new strings. One
     * for all of the row digits, and one for the column digits. Step 4: Begin
     * building the unencrypted test, letter 1 will be charAt(0) of row string for
     * the row in the square and chatAt(0) of the column string for column of the
     * square.
     *
     */

    public String decryptText(String input) {

        String output = "";
        String numberOutput = "";
        String index = "";
        int counter = 0;

        // Convert text to be decrypted into a number string.

        for (int i = 0; i < input.length(); i++) {

            numberOutput += toNumber(Character.toString(input.charAt(i)));
        }

        // Split number string in groups of numbers period(key) length. row first, then
        // column.

        int lastPeriodIndex = (numberOutput.length() / (Integer.parseInt(this.key) * 2)) - 1;
        int numbersLeft = numberOutput.length() % (Integer.parseInt(this.key) * 2);
        int fullPeriodsPerArray = numberOutput.length() / (Integer.parseInt(this.key) * 2);
        int periodsPerArray = fullPeriodsPerArray;

        if ((numberOutput.length() % Integer.parseInt(this.key)) > 0) {
            lastPeriodIndex += 1;
            periodsPerArray += 1;
        }

        String[] periodArrayRow = new String[periodsPerArray];
        String[] periodArrayColumn = new String[periodsPerArray];

        for (int i = 0; i < periodsPerArray; i++) {

            periodArrayRow[i] = "";
            periodArrayColumn[i] = "";
        }

        for (int i = 0; i < fullPeriodsPerArray; i++) {
            for (int j = 0; j < Integer.parseInt(this.key); j++) {
                periodArrayRow[i] += Character.toString(numberOutput.charAt(counter));
                counter++;
            }

            for (int j = 0; j < Integer.parseInt(this.key); j++) {
                periodArrayColumn[i] += Character.toString(numberOutput.charAt(counter));
                counter++;
            }
        }

        if (numbersLeft > 0) {
            for (int j = 0; j < (numbersLeft / 2); j++) {
                periodArrayRow[lastPeriodIndex] += Character.toString(numberOutput.charAt(counter));
                counter++;
            }

            for (int j = 0; j < numbersLeft / 2; j++) {
                periodArrayColumn[lastPeriodIndex] += Character.toString(numberOutput.charAt(counter));
                counter++;
            }
        }

        // Produce a new string of numbers for the row and column..

        counter = 0;
        String rowDigits = "";
        String columnDigits = "";

        for (int i = 0; i < periodsPerArray; i++) {
            rowDigits += periodArrayRow[i];
            columnDigits += periodArrayColumn[i];
        }

        // Now take rowDigits and columnDigits and complete the decryption.

        for (int i = 0; i < rowDigits.length(); i++) {

            index += Character.toString(rowDigits.charAt(i));
            index += Character.toString(columnDigits.charAt(i));
            output += toLetter(index);
            index = "";
        }

        return output;
    }
}
