package com.twu.biblioteca;

import java.io.PrintStream;

public enum Notifications {
	CheckOutSuccess("Thank you! Enjoy the book"),
	CheckOutFailure("Sorry, that book is not available"),
	ReturnSuccess("Thank you for returning the book"),
	ReturnFailure("That is not a valid book to return."),
	;
	String message;

	Notifications(String message) {
		this.message = message;
	}

	public void showNotification(PrintStream out) {
		out.println(message);
	}
}
