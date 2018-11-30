package ui;

import java.util.Scanner;

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
                int index2 = nativeBuilder.indexOf(breakOfCom, index1);
                this.command = nativeBuilder.substring(0, index1);

                if (index2 >= 0) {
                    int index3 = nativeBuilder.indexOf(breakOfCom, index2);
                    this.function = nativeBuilder.substring(index1, index2);

                    if (index3 >=0){
                        this.parameter = nativeBuilder.substring(index2, index3);
                        this.helpfinal = nativeBuilder.substring(index3, nativeBuilder.length() - 1);
                    }
                    else{
                        this.parameter = nativeBuilder.substring(index2, nativeBuilder.length() -1);
                    }
                }
                else {
                    this.function = nativeBuilder.substring(index1, nativeBuilder.length() - 1);
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
        if (command.equalsIgnoreCase("encrypt")) {

            System.out.println("Input Text.");
            System.out.println();

            String inputText = scom.nextLine();
            Encrypt enc = new Encrypt();
            String encryptedText = enc.encryptText(inputText);
            System.out.println(encryptedText);
        }
        if (command.equalsIgnoreCase("decrypt")){

            System.out.println("Input Text.");
            System.out.println();

            String inputText = scom.nextLine();
            Decrypt dec = new Decrypt();
            String decryptedText = dec.decryptText(inputText);
            System.out.println(decryptedText);
        }
        scom.close();
    }


}
