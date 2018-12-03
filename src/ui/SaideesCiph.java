package ui;

import java.util.Scanner;
import database.*;

public class SaideesCiph {

    private static String choice = "y";

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        boolean welcomeDisplayed = false;

        while (choice.equalsIgnoreCase("y")) {

            if (welcomeDisplayed) {
                System.out.println("Input command: ");
            }
            else {
                Help.welcomeMessage();
            }

            String command = sc.nextLine();

            ComTree action = new ComTree(command);

            action.execute();

            System.out.println("Would you like to continue? (y/n)");

        SaideesCiph.choice = sc.nextLine();

        }
        sc.close();
    }
}
