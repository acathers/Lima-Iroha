package ui;

public class Help {

    public static void welcomeMessage(){
        System.out.println("Welcome to the CeasarCiph program. Enter the command for what you would like to do. Type 'help' for a list of commands and information on the capabilities of CeaserCiph.");
    }
    public static void help() {
        System.out.println("CeasarsCiph is a simple text encryption and decryption program. With the following commands you can encrypt or decrypt a message with the default encryption of +4 to the char value or set up a custom encryption with a passphrase that alternates through each char of the passphrase adding the value of each letter to the text or a consistant addition of any integer value equal to or less than 256 to each char in the text");
        System.out.println();
        System.out.println("Below is a list of available commands. Type the command followed by help for more help with each command. Ex: 'Encrypt help'.");
        System.out.println();
        System.out.println("Encrypt" + "/n" + "Decrypt" + "/n" + "SetPassphrase");
        System.out.println();
    }
}
