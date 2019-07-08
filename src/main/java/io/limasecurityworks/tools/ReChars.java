/*
* This class will consist of methods that well take a string and return a string in different ways needed for encryption in this program.
*/

package io.limasecurityworks.tools;

public class ReChars {

    public static String reSpaces(String input) {

        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (!Character.toString(input.charAt(i)).equalsIgnoreCase(" ")) {
                output += Character.toString(input.charAt(i));
            }
        }

        return output;
    }

    public static String reAllNonLetters(String input) {

        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (StringBoolean.isAlpha(Character.toString(input.charAt(i)))) {
                output += Character.toString(input.charAt(i));
            }
        }

        return output;
    }

    public static String reAllNonLettersLeaveDigits(String input) {

        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (StringBoolean.isAlpha(Character.toString(input.charAt(i))) || Character.isDigit(input.charAt(i))) {
                output += Character.toString(input.charAt(i));
            }
        }

        return output;
    }

    public static String reAllNonLettersLeaveSpaces(String input) {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (StringBoolean.isAlpha(Character.toString(input.charAt(i)))) {
                output += Character.toString(input.charAt(i));
            } else if (Character.toString(input.charAt(i)).equalsIgnoreCase(" ")) {
                output += Character.toString(input.charAt(i));
            }
        }
        return output;
    }
}