package io.limasecurityworks.ui;

import io.limasecurityworks.ciphers.*;

public class ComTree {

    private String command;
    private String function;
    private String key;
    private String help;
    private String about;
    private int iKeyA;
    private int iKeyB;

    //Breaks up full command line into variables.

    ComTree(String stringCommand) {

        StringBuilder nativeBuilder = new StringBuilder(stringCommand);
        String breakOfCom = " ";

            //index1 is index of first space, used to determine if there is more than one word in the command. If there is no space, then it is a one word command and it is assigned to this.command in the else. If there is no space in the command, index1 will be given the value of '-1' due to how .indexOf works and the first if statement will return false and go to the else. This is why the if statement checks if index1 >= 0. It is just asking if there was a space.

            /*
            * This section will put words into fields in this order
            * 1. command
            * 2. function
            * 3. key
            * 4. help
            *
            * If there are more than 4 words in a command then it is invalid and user should
            * be prompted to enter a new command. Note: This needs to be worked on to do this.
            */

            int index1 = nativeBuilder.indexOf(breakOfCom);

            if (index1 >= 0) {
                int index2 = nativeBuilder.indexOf(breakOfCom, index1 + 1);
                this.command = nativeBuilder.substring(0, index1);

                if (index2 >= 0) {
                    int index3 = nativeBuilder.indexOf(breakOfCom, index2 + 1);
                    this.function = nativeBuilder.substring(index1 + 1, index2);

                    if (index3 >= 0) {
                        this.key = nativeBuilder.substring(index2 + 1, index3);
                        this.help = nativeBuilder.substring(index3 + 1, nativeBuilder.length());
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

            /*
            * If a command is put in with two keys for Affine Cipher and they are placed into this.key and this.help, then those two keys will be sent to iKeyA and iKeyB for Affine Cipher.
            */

            if (this.command.equalsIgnoreCase("Affine")) {

                if (this.key != null && this.help != null) {

                    if (isNumeric(this.key) && isNumeric(this.help)) {
                        this.iKeyA = Integer.parseInt(this.key);
                        this.iKeyB = Integer.parseInt(this.help);

                        if (this.about != null) {
                            this.help = this.about;
                            this.about = null;
                        }
                        else {
                            System.out.println("The only command that can be given after two int keys is help.");
                        }
                    }
                }
            }


            //Sorts out 'help' and 'about' commands to work with classes. Resets variable if it holds the help  or about command and sends the help command to this.helfFinal, and the about command to this.about.

            if (this.function != null) {
                if (this.function.equalsIgnoreCase("help")) {
                    this.help = this.function;
                    this.function = null;
                }
                else if (this.function.equalsIgnoreCase("about")) {
                    this.about = this.function;
                    this.function = null;
                }
            }
            if (this.key != null) {
                if (this.key.equalsIgnoreCase("help")) {
                    this.help = this.key;
                    this.key = null;
                }
                else if (this.key.equalsIgnoreCase("about")) {
                    this.about = this.key;
                    this.key = null;
                }
            }
            if (this.help != null && this.about != null) {
                this.command = "Invalid command. Help and About can not be used in the same command.";
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
        else if (command.equalsIgnoreCase("Exit")) {
            Iroha.exit = true;
        }
        else if (command.equalsIgnoreCase("Caesar")) {

            Caesar newCC = new Caesar(this.function, this.key, this.help, this.about);

            newCC.runCC();
        }
        else if (command.equalsIgnoreCase("ADFGVX")) {

            ADFGVX newAVC = new ADFGVX(this.function, this.key, this.help, this.about);

            newAVC.runAVC();
        }
        else if (command.equalsIgnoreCase("ADFGX")) {

            ADFGX newAC = new ADFGX(this.function, this.key, this.help, this.about);

            newAC.runAC();
        }
        else if (command.equalsIgnoreCase("Atbash")) {

            Atbash newAtbash = new Atbash(this.function, this.help, this.about);

            newAtbash.runAtbash();
        }
        else if (command.equalsIgnoreCase("ROT13")) {

            ROT13 newROT13 = new ROT13(this.function, this.help, this.about);

            newROT13.runROT13();
        }
        else if (command.equalsIgnoreCase("Affine")) {

            Affine newAffine = new Affine(this.function, this.iKeyA, this.iKeyB, this.help, this.about);

            newAffine.runAffine();
        }
        else if (command.equalsIgnoreCase("Autokey")) {

            Autokey newAutokey = new Autokey(this.function, this.key, this.help, this.about);

            newAutokey.runAutokey();
        }
        else if (command.equalsIgnoreCase("Baconian")) {

            Baconian newBaconian = new Baconian(this.function, this.help, this.about);

            newBaconian.runBaconian();
        }
        else if (command.equalsIgnoreCase("Base64")) {

            Base64 newBase64 = new Base64(this.function, this.help, this.about);

            newBase64.runBase64();
        }
        else if (command.equalsIgnoreCase("Beaufort")) {

            Beaufort newBeaufort = new Beaufort(this.function, this.key, this.help, this.about);

            newBeaufort.runBeaufort();
        }
        else {

            System.out.println("\n" + "Invlid command entered. Use help for more information.");
            Iroha.invalid = true;
        }
    }

    public boolean isNumeric(String input) {

        boolean isNumeric = true;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }
}
