package io.limasecurityworks.tools;

public class OddEven {

    public static boolean isOdd(int input) {
        if (input % 2 == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isEven(int input) {
        if (input % 2 == 0) {
            return true;
        }
        else return false;
    }
}
