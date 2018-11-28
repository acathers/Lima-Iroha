package ui;

import java.util.Scanner;

public class CeasarsCiph {

    public static void main(String args[]) {

        Help.welcomeMessage();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        if (command.equalsIgnoreCase("help")) {
            Help.help();
        }
        if (command.equalsIgnoreCase("encrypt")) {

            System.out.println("Input Text.");
            System.out.println();

            String inputText = sc.nextLine();
            Encrypt enc = new Encrypt();
            String encryptedText = enc.encryptText(inputText);
            System.out.println(encryptedText);
        }
        if (command.equalsIgnoreCase("decrypt")){

            System.out.println("Input Text.");
            System.out.println();

            String inputText = sc.nextLine();
            Decrypt dec = new Decrypt();
            String decryptedText = dec.decryptText(inputText);
            System.out.println(decryptedText);

        }
        sc.close();
    }
}
