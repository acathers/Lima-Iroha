package io.limasecurityworks.processes;

public class Function {

    public static String getFunction() {

        String function = "";

        System.out.print("\n" + "Would you like to Encrypt or Decrypt your text?: ");
        function = io.limasecurityworks.ui.Iroha.sc.nextLine();
        function = checkFunction(function);

        return function;
    }

    public static String checkFunction(String function) {

        while (!function.equalsIgnoreCase("encrypt") && !function.equalsIgnoreCase("decrypt")) {
            System.out.print("\n" + "Invalid function. Please enter 'Encrypt' or 'Decrypt':  ");

            String encDecResponseNull = io.limasecurityworks.ui.Iroha.sc.nextLine();

            if (!encDecResponseNull.equalsIgnoreCase("encrypt") && !encDecResponseNull.equalsIgnoreCase("decrypt")) {
                System.out.print("\n" + "Invalid function. Please enter 'Encrypt' or 'Decrypt':  ");
            } else {
                function = encDecResponseNull;
            }
        }

        return function;
    }
}

/*
 * 
 * if (this.function == null) {
 * 
 * System.out.print("Would you like to encrypt or decrypt?: ");
 * 
 * String functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine();
 * 
 * while (!functionChoice.equalsIgnoreCase("encrypt") &&
 * !functionChoice.equalsIgnoreCase("decrypt")) {
 * 
 * System.out.print("\n" +
 * "Invalid command for function, use either encrypt or decrypt: ");
 * 
 * functionChoice = io.limasecurityworks.ui.Iroha.sc.nextLine(); }
 * 
 * this.function = functionChoice; }
 * 
 */