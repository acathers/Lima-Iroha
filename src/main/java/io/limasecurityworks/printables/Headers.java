package io.limasecurityworks.printables;

import io.limasecurityworks.tools.ConsoleColors;

public class Headers {

    public static void translationHeader() {
        System.out.println("\n" + ConsoleColors.RED + "        ===== Output Results =====" + ConsoleColors.RESET);
    }

    public static void helpHeader() {
        System.out.println("\n" + ConsoleColors.RED + "        ===== Help =====" + ConsoleColors.RESET);
    }
}