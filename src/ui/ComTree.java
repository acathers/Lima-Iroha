package ui;

import java.util.Scanner;
import database.*;

public class ComTree {

    private String command = "";
    private String function = "";
    private String parameter = "";
    private String helpfinal = "";

    ComTree(String stringCommand) {
        StringBuilder nativeBuilder = new StringBuilder(stringCommand);
        String breakOfCom = " ";

            int index1 = nativeBuilder.indexOf(breakOfCom);

            if (index1 >= 0) {
                int index2 = nativeBuilder.indexOf(breakOfCom, index1 + 1);
                this.command = nativeBuilder.substring(0, index1 - 1);

                if (index2 >= 0) {
                    int index3 = nativeBuilder.indexOf(breakOfCom, index2 + 1);
                    this.function = nativeBuilder.substring(index1 + 1, index2 - 1);

                    if (index3 >=0) {
                        this.parameter = nativeBuilder.substring(index2 + 1, index3 - 1);
                        this.helpfinal = nativeBuilder.substring(index3 + 1, nativeBuilder.length() - 1);
                    }
                    else {
                        this.parameter = nativeBuilder.substring(index2 + 1, nativeBuilder.length() -1);
                    }
                }
                else {
                    this.function = nativeBuilder.substring(index1 + 1, nativeBuilder.length() - 1);
                }
            }
            else {
                this.command = nativeBuilder.toString();
            }
    }

    public void execute() {

        Scanner scom = new Scanner(System.in);

        if (command.equalsIgnoreCase("help")) {

            Help.help();
        }
        if (command.equalsIgnoreCase("CeasarsCipher")) {

            System.out.println("made it here");

            CeasarsCipher ccBuild = new CeasarsCipher(this.function, this.parameter, this.helpfinal);

            if (this.function.equalsIgnoreCase("encrypt")) {

            }
        }
        scom.close();
    }


}
