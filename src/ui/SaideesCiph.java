package ui;

import java.util.Scanner;

public class SaideesCiph {

    public static void main(String args[]) {

        String choice = "y";
        Scanner sc = new Scanner(System.in);

        while (choice.equalsIgnoreCase("y")) {

            Help helpDisplay = new Help();

            helpDisplay.welcomeMessage();

            System.out.println("test a");

            String command = sc.nextLine();

            System.out.println("test b");

            ComTree action = new ComTree(command);

            System.out.println("test c");

            action.execute();

            System.out.println("Would you like to continue? (y/n)");

            choice = sc.nextLine();

        }
        sc.close();
    }
}
