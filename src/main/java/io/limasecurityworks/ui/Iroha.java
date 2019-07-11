/*
* Iroha Encryption Software by Iskra#0332. Project began in December of 2018.
*
* The main class is fairly short at the moment and the ComTree class attemps to handle
* as much of the command line work as possible before being sent to a cipher file.
*
* If you understand the Iroha and ComTree class before you jump into a cipher file, it could
* help in understanding a cipher file and why it was made the way it was.
*
*/

package io.limasecurityworks.ui;

import java.util.Scanner;

public class Iroha {

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Command currentCommand;
		CommandRunner commandRunner = new CommandRunner();

		Menu.displayWelcomeMessage();

		do {
			Menu.displayCommandPrompt();
			currentCommand = Command.valueOf(sc.nextLine().toUpperCase());
			System.out.println(currentCommand.toString()); // test remove
			commandRunner.execute(currentCommand);
		} while (!currentCommand.equals(Command.EXIT));

		Menu.displayExitMessage();

	}
}
