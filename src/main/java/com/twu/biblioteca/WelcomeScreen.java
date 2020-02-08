package com.twu.biblioteca;

public class WelcomeScreen {
	private final String message;

	public WelcomeScreen(String message) {
		this.message = message;
	}

	public void showMessage() {
		System.out.println(message);
	}
}
