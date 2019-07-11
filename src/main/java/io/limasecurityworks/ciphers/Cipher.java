package io.limasecurityworks.ciphers;

import io.limasecurityworks.ui.Command;

public abstract class Cipher {
	
	protected Command function;
	
	public Cipher() {
		this.function = Command.NONE;
	}
	
	public abstract void run();

	public void displayHelp() {
		System.out.println("You should get help, but I have yet to develop help for this part of the program at this time.");
	}
	
	public void displayAbout() {
		System.out.println("You should get an about message, but I have yet to develop about for this part of the program at this time.");

	}
	
	public void setFunction(Command function) {
		this.function = function;
	}
	
	
	
	
	
}
