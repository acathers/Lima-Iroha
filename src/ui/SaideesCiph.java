package ui;

import java.util.Scanner;
import database.*;

public class SaideesCiph {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean welcomeDisplayed = false;
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            if (welcomeDisplayed) {
                System.out.println("Input command: ");
                welcomeDisplayed = false;
            }
            else {
                Help.welcomeMessage();
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
