package com.twu.biblioteca;

import java.io.PrintStream;

public enum Notifications {
	WELCOME("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
	INVALID_INPUT("Please select a valid option!"),
	CHECK_OUT_SUCCESS("Thank you! Enjoy the book"),
	CHECK_OUT_FAILURE("Sorry, that book is not available"),
	RETURN_SUCCESS("Thank you for returning the book"),
	RETURN_FAILURE("That is not a valid book to return."),
	NO_BOOK_AVAILABLE("No Books Available in Library Now!"),
	;
	String message;

	Notifications(String message) {
		this.message = message;
	}

	public void showNotificationOn(PrintStream out) {
		out.println(message);
	}
}
