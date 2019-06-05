package io.limasecurityworks.tools;

public class StringBoolean {

    // In Autokey

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

    // In Autokey

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