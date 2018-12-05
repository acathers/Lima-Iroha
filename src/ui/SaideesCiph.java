package ui;

import java.util.Scanner;
import database.*;

public class SaideesCiph {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean welcomeDisplayed = false;
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            if (welcomeDisplayed == true) {
                System.out.println("Input command: ");
            }
            else {
                Help.welcomeMessage();
                welcomeDisplayed = true;
            }

            String command = sc.nextLine();

            ComTree action = new ComTree(command);

            action.execute();

            System.out.print("Would you like to continue? (y/n): ");
            choice = sc.nextLine();
        }
        sc.close();
    }
}
