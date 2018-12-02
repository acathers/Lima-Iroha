package ui;

import java.util.Scanner;

public class SaideesCiph {

    public static void main(String args[]) {

        String choice = "y";
        Scanner sc = new Scanner(System.in);

        while (choice.equalsIgnoreCase("y")) {

            Help.welcomeMessage();

            String command = sc.nextLine();

            ComTree action = new ComTree(command);

            action.execute();

            System.out.println("Would you like to continue? (y/n)");

            choice = sc.nextLine();

        }
        sc.close();
    }
}
