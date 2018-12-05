package database;

public class Help {

    public static void welcomeMessage(){
        System.out.println("Welcome to the CeasarCiph program. Enter the command for what you would like to do. Type 'help' for a list of commands and information on the capabilities of CeaserCiph.");
        System.out.println();
    }
    public static void help() {
        System.out.println("CeasarsCiph is a simple text encryption and decryption program. With the following commands you can encrypt or decrypt a message with the default encryption of +3 to the char value.");
        System.out.println();
        System.out.println("Below is a list of available commands. Type the command followed by help for more help with each command. Ex: 'Encrypt help'.");
        System.out.println();
        System.out.println("Help" + "\n" + "CeasarCipher" + "\n" + "");
        System.out.println();
    }
}
