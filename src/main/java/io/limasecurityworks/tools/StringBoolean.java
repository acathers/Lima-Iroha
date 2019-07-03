package io.limasecurityworks.tools;

public class StringBoolean {

    // Checks that all characters in a strung are letters
    public static boolean isAlpha(String input) {

        char[] chars = input.toCharArray();
        boolean allLetters = true;

        for (char c : chars) {
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                allLetters = false;
                break;
            }
        }
        return allLetters;
    }

    public static boolean isNumeric(String input) {

        char[] chars = input.toCharArray();
        boolean allNumbers = true;

        for (char c : chars) {
            if (!Character.isDigit(c) && c != ' ') {
                allNumbers = false;
                break;
            }
        }
        return allNumbers;
    }

    public static boolean hasDigits(String input) {

        char[] chars = input.toCharArray();
        boolean hasNumbers = false;

        for (char c : chars) {
            if (Character.isDigit(c)) {
                hasNumbers = true;
                break;
            }
        }
        return hasNumbers;
    }

    // In Autokey

    public static boolean hasSpaces(String input) {

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