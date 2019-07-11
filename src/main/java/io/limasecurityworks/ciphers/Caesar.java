package io.limasecurityworks.ciphers;

import java.lang.StringBuilder;
import io.limasecurityworks.processes.*;
import io.limasecurityworks.info.Help;
import io.limasecurityworks.printables.*;
import io.limasecurityworks.tools.*;
import io.limasecurityworks.ui.*;

public class Caesar extends Cipher {

	// variables for the constructor and the encryption and decryption key. Default
	// is set to 3 but there are methods to customize the key.

	private String key;
	private static int encryDef = 3;
	private static int decryDef = -3;

	// Constructor sets the variables for the class. 'function' is Encrypt or
	// Decrypt, 'key' will be the key which is 3 by default, 'help' is used for
	// triggering help.

	public Caesar() {
	}

	// Class is ran from here, this method should execute anything in the class
	// needed from the command. The if statment sorts out the command and executes
	// the methods as needed.

	public void run() {

		if (key == null) {
			if (function.equals(Command.ENCRYPT)) {
				key = "3";
			} else {
				key = "-3";
			}
		}

		else {
			while (!checkKey(key)) {
				System.out.println();
				System.out.println("The key may only contain numbers and must be between 1 and 26.");
				System.out.print("Input key, numbers only: ");
				key = io.limasecurityworks.ui.Iroha.sc.nextLine();
			}
		}

		// Get text to be encrypted.
		System.out.print("Input Text:      ");

		String input = io.limasecurityworks.ui.Iroha.sc.nextLine();

		while (!checkInput(input)) {
			System.out.println();
			System.out.println("Numbers can not be encrypted with Caesars Cipher, please spell them out.");
			System.out.print("Input text without numbers:");

			input = io.limasecurityworks.ui.Iroha.sc.nextLine();
		}

		if (function.equals(Command.ENCRYPT)) {
			Printables.createPrintout(input, function.toString(), null, encryptText(input), key);

		} else if (function.equals(Command.DECRYPT)) {
			Printables.createPrintout(input, function.toString(), null, decryptText(input), key);

		} else {
			System.out.println("This should be an impossible function error. Function is not encrypt or decrypt");
		}
	}

	// check the key to ensure it is valid, must be all numbers.
	public static boolean checkKey(String input) {

		if (StringBoolean.isNumeric(input) && (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 26)) {
			return true;
		} else {
			return false;
		}
	}

	// check the input to ensure it is valid (no numbers), the rest aside from
	// letters will be deleted.
	public static boolean checkInput(String input) {

		if (StringBoolean.hasDigits(input)) {
			return false;
		} else {
			return true;
		}
	}

	public static String cleanInput(String input) {

		String cleanInput;

		cleanInput = ReChars.reAllNonLettersLeaveSpaces(input);

		return cleanInput;
	}

	// Used to encrypt your text.

	public String encryptText(String input) {

		encryDef = Integer.parseInt(key);

		String inputUC = input.toUpperCase();

		StringBuilder output = new StringBuilder();

		for (int i = 0; i < inputUC.length(); i++) {
			if (inputUC.charAt(i) == 32) {
				output.append(inputUC.charAt(i));
			} else if (inputUC.charAt(i) > 90 - encryDef) {
				char place = inputUC.charAt(i);
				char encryPlace = (char) (place + encryDef);
				char encryPlaceWrap = (char) (encryPlace - 26);
				output.append(encryPlaceWrap);
			} else {
				char place = inputUC.charAt(i);
				char encryPlace = (char) (place + encryDef);
				output.append(encryPlace);
			}
		}
		return output.toString();
	}

	// Used to decrypt your text.

	public String decryptText(String input) {

		decryDef = -1 * Integer.parseInt(key);

		String inputUC = input.toUpperCase();

		StringBuilder output = new StringBuilder();

		for (int i = 0; i < inputUC.length(); i++) {
			if (inputUC.charAt(i) == 32) {
				output.append(inputUC.charAt(i));
			} else if (inputUC.charAt(i) < 65 - decryDef) {
				char place = inputUC.charAt(i);
				char decryPlace = (char) (place + decryDef);
				char decryPlaceWrap = (char) (decryPlace + 26);
				output.append(decryPlaceWrap);
			} else {
				char place = inputUC.charAt(i);
				char decryPlace = (char) (place + decryDef);
				output.append(decryPlace);
			}
		}
		return output.toString();
	}

	public void setFunction(Command command) {
		if (command.equals(Command.ENCRYPT) || command.equals(Command.DECRYPT)) {
			this.function = command;
		}
	}

	public void displayAbout() {
		System.out.println("\n"
				+ "In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence"
				+ "\n" + "\n" + "--Source: Suetonius, Vita Divi Julii 56.6");
	}
}
