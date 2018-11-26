package ui;

import java.util.Scanner;

public class CeasarsCiph {

    public static void main(String args[]) {

        welcomeMessage();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        if (command == equalsIgnoreCase("help")) {
            help();
        }
        if (command == equalsIgnoreCase("encrypt")) {

            System.out.println("Input Text.");
            System.out.println();

            String inputText = sc.nextLine();
            encryptedText = encryptText(inputText);
            System.out.println(encryptedText);
        }
        if (command == equalsIgnoreCase("decrypt")){

            System.out.println("Input Text.");
            System.out.println();

            String inputText = sc.nextLine();
            decryptedText = decryptText(inputText);
            System.out.println(decryptedText);

        }
    }
    sc.close();
}
