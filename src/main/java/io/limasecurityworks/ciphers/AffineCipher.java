package io.limasecurityworks.ciphers;

public class AffineCipher {

    private String function;
    private int iKeyA;
    private int iKeyB;
    private int modulo;
    private String help;
    private String about;

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
                System.out.println("Help for function alone");
            }
            else {
                System.out.println("Help for Affine Cipher");
            }
        }

        else if (this.about != null) {
            System.out.println("About Affine Cipher.");
        }

        else {

            // Find out if there is a function, if not, get it.

            if (this.function == null) {

                System.out.print("Would you like to encrypt or decrypt?: ");

                String functionChoice = ui.Lima.sc.nextLine();

                while (!functionChoice.equalsIgnoreCase("encrypt") && !functionChoice.equalsIgnoreCase("decrypt")) {

                    System.out.print("\n" + "Invalid command for function, use either encrypt or decrypt: ");

                    functionChoice = ui.Lima.sc.nextLine();
                }

                this.function = functionChoice;

            }

            /*
            * Set modulo. 26U, 52 (letters upper and lower and numbers), or 127 (all chars).
            */

            boolean validModulo = false;

            System.out.print("Input number of characters to be used: ");

            String moduloChoice = ui.Lima.sc.nextLine();

            while (!validModulo) {

                if (moduloChoice == "26" || moduloChoice == "52" || moduloChoice == "127") {

                    this.modulo = Integer.parseInt(moduloChoice);

                    validModulo = true;
                }

                else {
                    System.out.print("Invalid input, enter either 26, 52, or 127: ");

                    moduloChoice = ui.Lima.sc.nextLine();
                }
            }

            // Find out if keys have been suplemented, if not, get them.

            if (this.iKeyA == 0 && this.iKeyA == 0) {

                System.out.print("Input keys. Ex. : ");

            }

            // Get input text and execute cipher.

            System.out.print("Input text: ");

            String inputText = ui.Lima.sc.nextLine();

        }

    }

    public boolean isCoprime(int key, int mod) {

        boolean isCoprime = false;

        return isCoprime;
    }

    public void setKeys(int keyA, int keyB) {

        this.iKeyA = keyA;
        this.iKeyB = keyB;

    }

    /*
    * E (x) = (ax + b) mod m
    * x = Char value in order of alphabet
    * a = ikeyA or your first key which must be a coprime of m.
    * b = iKeyB or your second key which can be any number.
    * m = number of letters in the alphabet or number of available characters there are.
    */

    public String encryptText(String input) {

        char[] charArray = input.toCharArray();
        char[] output = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (charArray[i] != ' ') {
                output[i] = (char)((iKeyA * charArray[i] + iKeyB) % modulo);
            }
        }
        return String.valueOf(output);
    }

    /*
    * D(x) = a^-1 (x-b) mod m
    * a*-1 = modular multiplicative inverse of a modulo m .
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
                output[1] = (char)(iKeyAInverse * (charArray[i] + iKeyB) % modulo);
            }
        }
        return String.valueOf(output);
    }
}
