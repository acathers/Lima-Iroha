package io.limasecurityworks.printables;

import io.limasecurityworks.tools.ConsoleColors;

public class Printables {

	public static void translationHeader() {
		System.out.println("\n" + ConsoleColors.RED + "        ===== Output Results =====" + ConsoleColors.RESET);
	}

	public static void helpHeader() {
		System.out.println("\n" + ConsoleColors.RED + "        ===== Help =====" + ConsoleColors.RESET);
	}

	public static String createPrintout(String input, String function, String keySquare, String output,
			String... keys) {
		translationHeader();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-10s%s%n", "Input:", input));
		sb.append(String.format("%-10s%s%n", "KeySquare:", keySquare));
		for (String key : keys) {
			sb.append(String.format("%-10s%s%n", "Key:", key));
		}
		sb.append(String.format("%-10s%s", function + "text :", output));

		return sb.toString();
	}

}
