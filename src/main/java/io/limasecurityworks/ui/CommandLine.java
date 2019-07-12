package io.limasecurityworks.ui;

public class CommandLine {

	private final static Scanner input = new Scanner(System.in);

	public void run() {

	}

	public Command createCommand(String first, String second, String third,
			String fourth, int arg) {

		return new Command.Builder().command(first)
				.withAdditionalCommand(second).withAdditionalCommand(third)
				.withAdditionalCommand(fourth).withIntArgs(arg).build();
	}

	public Command createCommand(String first, String second, String third,
			int arg) {

		return new Command.Builder().command(first)
				.withAdditionalCommand(second).withAdditionalCommand(third)
				.withIntArgs(arg).build();
	}

}
