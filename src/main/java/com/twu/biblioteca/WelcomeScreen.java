package com.twu.biblioteca;

import java.io.PrintStream;

public class WelcomeScreen {
	private final String message;
	private PrintStream out;

	public WelcomeScreen(String message, PrintStream out) {
		this.message = message;
		this.out = out;
	}

	public void showMessage() {
		out.println(message);
	}
}
