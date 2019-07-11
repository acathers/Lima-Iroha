package io.limasecurityworks.ui;

import java.util.Arrays;
import java.util.List;

import io.limasecurityworks.ciphers.Caesar;
import io.limasecurityworks.info.Help;

public class CommandRunner {
	
	Command function;


	public void execute(Command... commandsArray) {
		

		if (commandsArray.length > 4) {
			throw new Exception("Too many arguments");
		}

		List<Command> commands = Arrays.asList(commandsArray);

		if (commands.contains(Command.HELP) && commands.contains(Command.ABOUT)) {
			throw new Exception("Invalid arguments, cannot use help and about in same command sequence");
		}

		for (Command command : commands) {

			switch (command) {
			case EXIT:
				return;
			case HELP:
				Help.help();
				break;
			case ABOUT:
				Help.about();
				break;
			case CAESAR:
				new Caesar(this.function, this.key, this.help, this.about).runCC();

			default:
				Menu.displayInvalidCommand();
			}
		}
	}
	
	

}
