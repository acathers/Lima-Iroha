package io.limasecurityworks.ui;

import io.limasecurityworks.ui.Command.Builder;

public class Command {
	final private String command;
	final private boolean hasIntArg;
	final private int numberOfCommands;
	final private int numberOfArguments;
	final private String[] commands;
	final private int[] args;

	private Command(String command, boolean hasIntArg, int numberOfCommands, int numberOfArguments, String[] commands,
			int[] args) {
		super();
		if (command == null) {
			throw new IllegalArgumentException("command cannot be null");
		}
		this.command = command;
		this.hasIntArg = hasIntArg;
		if (numberOfCommands == 0) {
			throw new IllegalArgumentException("Cannot have a command object with zero commands");
		}
		this.numberOfCommands = numberOfCommands;

		this.numberOfArguments = numberOfArguments;

		if (numberOfCommands != commands.length) {
			throw new IllegalArgumentException(
					"Stated number of commands differs from actual number of commands provided");
		}
		this.commands = commands;
		if (numberOfArguments != args.length) {
			throw new IllegalArgumentException(
					"Stated number of arguments differs from actual number of arguments provided");
		}
		this.args = args;
	}

	public String getCommand() {
		return command;
	}

	public boolean hasIntArg() {
		return hasIntArg;
	}

	public int getNumberOfCommands() {
		return numberOfCommands;
	}

	public int getNumberOfArguments() {
		return numberOfArguments;
	}

	public String[] getCommands() {
		return commands;
	}

	public int[] getArgs() {
		return args;
	}

	public static class Builder {

		/// instance fields
		private StringBuilder command;
		private boolean hasIntArg;
		private int numberOfCommands;
		private int numberOfArguments;
		private String[] commands;
		private int[] args;

		public Builder() {
		}

		public Builder command(String command) {
			this.command = new StringBuilder(command.trim());
			return this;
		}

		public Builder withIntArgs(int... args) {
			if (args != null) {
				numberOfArguments += args.length;
			}
			hasIntArg = true;
			return this;
		}

		public Builder withAdditionalCommand(String command) {
			if (this.command == null) {
				throw new RuntimeException("Cannot use Command.withAdditonalCommand before Command.command");
			}
			
			this.command.append(" " + command.trim());
			return this;
		}

		public Command build() {
			return new Command(command.toString(), hasIntArg, numberOfCommands, numberOfArguments, commands, args);
		}

	}
}
