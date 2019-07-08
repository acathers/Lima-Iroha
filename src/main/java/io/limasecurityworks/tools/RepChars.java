package io.limasecurityworks.tools;

public class RepChars {

    public static String replaceCharacter(String input, String letterA, String letterB) {

        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (!Character.toString(input.charAt(i)).equalsIgnoreCase(letterA)) {
                output += Character.toString(input.charAt(i));
            }

            else {
                output += letterB;
            }
        }
        return output;
    }

}