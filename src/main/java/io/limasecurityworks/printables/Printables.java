package io.limasecurityworks.printables;

public class Printables {

	private final static String format = "%-20s%s%n";

	public static void createPrintout(String input, String function, String keySquare, String output, String... keys) {
		Headers.translationHeader();
		function = function.substring(0, 1).toUpperCase() + function.substring(1);
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(format, "Input:", input));

		if (keySquare != null) {
			sb.append(String.format(format, "Key Square:", keySquare));
		}

		if (keys != null) { 
			for (String key : keys) {
				sb.append(String.format(format, "Key:", key));
			}
		}

		sb.append(String.format(format, function + "ed Text:", output));
		System.out.println(sb.toString());
	}
}