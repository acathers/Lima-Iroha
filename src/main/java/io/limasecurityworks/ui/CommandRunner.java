package io.limasecurityworks.ui;

import java.util.Arrays;
import java.util.List;

import io.limasecurityworks.ciphers.Caesar;
import io.limasecurityworks.ciphers.Cipher;
import io.limasecurityworks.info.Help;

public class CommandRunner {

	private Command commandFocus = Command.NONE; // current command we're focused on for additional options
	private Cipher currentCipher = null;

	public void execute(Command command) {

		switch (command) {
		case EXIT:
			return;
		case HELP:
			executeHelp();
			break;
		case ABOUT:
			Help.about();
			break;
		case CAESAR:
			currentCipher = new Caesar();
			Menu.displayEncryptDecryptPrompt();
			break;
		case ENCRYPT:
			executeCipherFunction(Command.ENCRYPT);
			break;
		case DECRYPT:
			executeCipherFunction(Command.DECRYPT);
			break;
		default:
			Menu.displayInvalidCommand();
		}

		commandFocus = command;
	}

	private void executeHelp() {
		if (commandFocus.equals(Command.NONE)) {
			Help.help();
		} else {
			currentCipher.displayHelp();
		}
	}

	private void executeCipherFunction(Command command) {
		if (currentCipher != null) {
			currentCipher.setFunction(command);
			currentCipher.run();
		} else {
			Menu.displayEncryptDecryptSelectionErrorMessage();
		}
	}

}
