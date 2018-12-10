package database;

public class Help {

    //method for the welcome message which is displayed at the begginning of the program and should only be displayed once.

    public static void welcomeMessage(){
        System.out.println("\n" + "Welcome to the CaesarCiph program. Enter the command for what you would like to do. Type 'help' for a list of commands and information on the capabilities of CeaserCiph.");
        System.out.println();
        System.out.print("Command: ");
    }

    //method for the "Help" command.

    public static void help() {
        System.out.println("\n" +"========== Help ==========" + "\n" + "CaesarsCiph is a simple text encryption and decryption program. With the following commands you can encrypt or decrypt a message with the default encryption of +3 to the char value.");
        System.out.println();
        System.out.println("Below is a list of available commands. Type the command followed by help for more help with each command." + "\n" + "\n" + "Ex: CaesarCipher help"  + "\n" + "\n" + "You may also find information about this program by using command 'About' or more information about a command by typing your command followed by About. Ex: CaesarCipher About.");
        System.out.println();
        System.out.print("Help" + "\n" + "CaesarCipher" + "\n" + "About");
    }

    public static void about() {
        System.out.println("\n" + "This program was created by Iskra0332. Program was started in Nov 2018 with the intention of learning Java and also making something fun, useful, and interesting.");
    }
}
