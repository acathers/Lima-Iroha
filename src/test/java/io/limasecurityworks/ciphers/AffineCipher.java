package io.limasecurityworks.ciphers;

public class AffineCipher {

    private String function;
    private int iKeyA;
    private int iKeyB;
    private int modulo;
    private String help;
    private String about;

    private String modulo95 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&\'()*+,-./0123456789:;<=>?@[\\]^_`{|}~";
    public AffineCipher(String function, int iKeyA, int iKeyB, String help, String about) {
        this.function = function;
        this.iKeyA = iKeyA;
        this.iKeyB = iKeyB;
        this.help = help;
        this.about = about;
    }

    public void runAffine() {

        if (this.help != null) {

            if (this.function != null && this.iKeyA != 0 && this.iKeyB != 0) {
                System.out.println("You have entered a command with a function to either encrypt or decrypt and keys. The first key must be a coprime of the total number of available characters for it to work correctly.");
            }
            else if (this.function != null) {
                System.out.println("You may choose to either 'encrypt' or 'decrypt' a message with the Affine Cipher. You will need two keys for either action. Both keys will be a number and the first number must be a coprime of the total number of available characters for it to work correctly. The total number of characters must be 25, 52, or 95 for this program.");
            }
            else {
                System.out.println("Affine Cipher will ask you to encrypt or decrypt and will require two keys, both being numbers and the first key must be a coprime of the total number of available characters. Total number of characters must be 26, 52, or 95 for this program.");
            }
        }

        else if (this.about != null) {
            System.out.println("About Affine Cipher.");
        }

        else {

            // Find out if there is a function, if not, get it.

            if (this.function == null) {

                System.out.print("Would you like to encrypt or decrypt?: ");

                String functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();

                while (!functionChoice.equalsIgnoreCase("encrypt") && !functionChoice.equalsIgnoreCase("decrypt")) {

                    System.out.print("\n" + "Invalid command for function, use either encrypt or decrypt: ");

                    functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }

                this.function = functionChoice;
            }

            /*
            * Set modulo. 26U, 52 (letters upper and lower and numbers), or 95 (all chars).
            */

            boolean validModulo = false;

            System.out.print("Input number of characters to be used: ");

            String moduloChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();

            while (!validModulo) {

                if (moduloChoice.equals("26") || moduloChoice.equals("52") || moduloChoice.equals("95")) {

                    this.modulo = Integer.parseInt(moduloChoice);

                    validModulo = true;
                }

                else {

                    System.out.print("Invalid input, enter either 26, 52, or 95: ");

                    moduloChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();
                }
            }

            // Find out if keys have been suplemented, if not, get them.

            if (this.iKeyA == 0 && this.iKeyA == 0) {

                System.out.print("Input key 1: ");

                this.iKeyA = io.limasecurityworks.ui.Iroha.sc.nextInt();

                while (!isCoprime(this.iKeyA, this.modulo)) {

                    System.out.println();
                    System.out.print("That number is not a coprime with the mod. You have selected " + modulo + " as the mod. Your first key must have a greatest common factor with the mod of '1'. Enter input for key 1: ");

                    this.iKeyA = io.limasecurityworks.ui.Iroha.sc.nextInt();
                }

                System.out.print("Input key 2: ");

                this.iKeyB = io.limasecurityworks.ui.Iroha.sc.nextInt();

                while (this.iKeyB <= 0 || this.iKeyB >= this.modulo) {

                    System.out.println();
                    System.out.print("The second key must be greater than 0 and less than the mod. Your have selected " + this.modulo + "as the mod. Enter input for key 2: ");

                    this.iKeyB = io.limasecurityworks.ui.Iroha.sc.nextInt();
                }
            }

            // Get input text and execute cipher.

            io.limasecurityworks.ui.Iroha.sc.nextLine(); // Need to eat the new line.
            System.out.print("Input text: ");

            String inputText = io.limasecurityworks.ui.Iroha.sc.nextLine();

            if (this.function.equalsIgnoreCase("encrypt")) {

                String encryptedText = encryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key 1:    " + this.iKeyA + "\n" + "Key 2:    " + this.iKeyB + "\n" + "Mod:      " + this.modulo + "\n" + "Input:    " + inputText + "\n" + "Output:   " + encryptedText);
            }

            else if (this.function.equalsIgnoreCase("decrypt")) {

                String decryptedText = decryptText(inputText);

                System.out.println("\n" + "Function: " + this.function + "\n" + "Key 1:    " + this.iKeyA + "\n" + "Key 2:    " + this.iKeyB + "\n" + "Mod:      " + this.modulo + "\n" + "Input:    " + inputText + "\n" + "Output:   " + decryptedText);
            }

            else {
                System.out.println("Something has gone terribly wrong. Please report this to iskra0332@gmx.com");
            }
        }
    }

    public boolean isCoprime(int key, int mod) {

        boolean isCoprime = false;

        if (isEven(key) && isEven(mod)) {
            return isCoprime;
        }

        else if (key == 1) {
            isCoprime = true;
            return isCoprime;
        }

        else if (key <= 0) {
            return isCoprime;
        }

        else {

            int coprimeMod = 777;
            while (coprimeMod != 0) {

                int a = mod % key;
                coprimeMod = a;

                    if (coprimeMod != 0) {
                        mod = key;
                        key = a;
                    }
            }
            if (key == 1) {
                isCoprime = true;
            }
            return isCoprime;
        }
    }

    public boolean isEven(int input) {

        boolean even = false;

        if (input % 2 == 0) {
            even = true;
        }
        return even;
    }

    public void setKeys(int keyA, int keyB) {

        this.iKeyA = keyA;
        this.iKeyB = keyB;
    }

    /*
    * E (x) = (ax + b) mod m
    * x = Char value in order of alphabet
    * a = ikeyA or your first key which must be a coprime of m.
    * b = iKeyB or your second key which can be any number greater than 0 and less than mod.
    * m = number of letters in the alphabet or number of available characters there are.
    */

    public String encryptText(String input) {

        char[] charArray = input.toCharArray();
        char[] output = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (charArray[i] != ' ') {
                output[i] = modulo95.charAt(((iKeyA * modulo95.indexOf(charArray[i])) + iKeyB) % modulo);
            }
        }
        return String.valueOf(output);
    }

    /*
    * D(x) = a^-1 * (x-b) mod m
    * a*-1 = modular multiplicative inverse of iKeyA.
    * x = Char value in order of alphabet.
    * b = iKeyB or your second key which can be any number.
    * m = number of letters in the alphabet or number of available characters there are.
    */

    public String decryptText(String input) {

        char[] charArray = input.toCharArray();
        char[] output = new char[input.length()];

        int iKeyAInverse = 0;

        for (int i = 0; i < modulo; i++) {
            if ((iKeyA * i) % modulo == 1) {
                iKeyAInverse = i;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (charArray[i] != ' ') {

                if (modulo95.indexOf(charArray[i]) >= iKeyB) {

                    output[i] = modulo95.charAt((iKeyAInverse * (modulo95.indexOf(charArray[i]) - iKeyB)) % modulo);
                }
                else {

                    //Brain Buster!! Will explain later. 26+ needed to be added to make this work right.

                    output[i] = modulo95.charAt(modulo + ((iKeyAInverse * (modulo95.indexOf(charArray[i]) - iKeyB)) % modulo));
                }
            }
        }
        return String.valueOf(output);
    }
}
