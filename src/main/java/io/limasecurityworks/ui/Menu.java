package io.limasecurityworks.ui;

import io.limasecurityworks.info.Help;
import io.limasecurityworks.tools.ConsoleColors;

public class Menu {

	public static void displayWelcomeMessage() {
		Help.welcomeMessage();
	}

	public static void displayCommandPrompt() {
		System.out.print("Command: ");
	}

	public static void displayInvalidCommand() {
		System.out.print("Invalid command");
	}

	public static void displayExitMessage() {
		System.out.println("\n" + ConsoleColors.RED + "Program terminated." + ConsoleColors.RESET);
	}

	public static void displayEncryptDecryptPrompt() {

		System.out.print("\r\n" + "Next enter your choice to Encrypt or Decrypt \n");
	}
	
	public static void displayEncryptDecryptSelectionErrorMessage() {
		System.out.println("Can only select Encrypt/Decrypt after you've selected a Cipher");
	}

}
