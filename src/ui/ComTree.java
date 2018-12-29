package ui;

import java.util.Scanner;
import ciphers.*;

public class ComTree {

    private String command;
    private String function;
    private String key;
    private String helpFinal;
    private String about;

    //Breaks up full command line into variables.

    ComTree(String stringCommand) {

        StringBuilder nativeBuilder = new StringBuilder(stringCommand);
        String breakOfCom = " ";

            //index1 is index of first space, used to determine if there is more than one word in the command. If there is no space, then it is a one word command and it is assigned to this.command in the else. If there is no space in the command, index1 will be given the value of '-1' due to how .indexOf works and the first if statement will return false and go to the else. This is why the if statement checks if index1 >= 0. It is just asking if there was a space.

            int index1 = nativeBuilder.indexOf(breakOfCom);

            if (index1 >= 0) {
                int index2 = nativeBuilder.indexOf(breakOfCom, index1 + 1);
                this.command = nativeBuilder.substring(0, index1);

                if (index2 >= 0) {
                    int index3 = nativeBuilder.indexOf(breakOfCom, index2 + 1);
                    this.function = nativeBuilder.substring(index1 + 1, index2);

                    if (index3 >= 0) {
                        this.key = nativeBuilder.substring(index2 + 1, index3);
                        this.helpFinal = nativeBuilder.substring(index3 + 1, nativeBuilder.length());
                    }
                    else {
                        this.key = nativeBuilder.substring(index2 + 1, nativeBuilder.length());
                    }
                }
                else {
                    this.function = nativeBuilder.substring(index1 + 1, nativeBuilder.length());
                }
            }
            else {
                this.command = nativeBuilder.toString();
            }

            //Sorts out 'help' and 'about' commands to work with classes. Resets variable if it holds the help  or about command and sends the help command to this.helfFinal, and the about command to this.about.

            if (this.function != null) {
                if (this.function.equalsIgnoreCase("help")) {
                    this.helpFinal = this.function;
                    this.function = null;
                }
                else if (this.function.equalsIgnoreCase("About")) {
                    this.about = this.function;
                    this.function = null;
                }

            }
            if (this.key != null) {
                if (this.key.equalsIgnoreCase("help")) {
                    this.helpFinal = this.key;
                    this.key = null;
                }
            }
            if (this.help != null && this.about != null) {
                this.command = "Invalid";
            }
    }

    //Method sends command to appropriate class to be executed.

    public void execute() {

        if (command.equalsIgnoreCase("Help")) {
            Help.help();
        }
        else if (command.equalsIgnoreCase("About")) {
            Help.about();
        }
        else if (command.equalsIgnoreCase("Caesar")) {

            CaesarCipher newCC = new CaesarCipher(this.function, this.key, this.helpFinal, this.about);

            newCC.runCC();
        }
        else if (command.equalsIgnoreCase("ADFGVX")) {

            ADFGVXCipher newAVC = new ADFGVXCipher(this.function, this.key, this.helpFinal, this.about);

            newAVC.runAVC();
        }
        else if (command.equalsIgnoreCase("ADFGX")) {

            ADFGXCipher newAC = new ADFGXCipher(this.function, this.key, this.helpFinal, this.about);

            newAC.runAC();
        }
        else {

            System.out.println("\n" + "Invlid command entered. Use help for more information.");
            Lima.invalid = true;
        }
    }
}
