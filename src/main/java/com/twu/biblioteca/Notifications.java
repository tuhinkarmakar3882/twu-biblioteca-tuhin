package com.twu.biblioteca;

import java.io.PrintStream;

public enum Notifications {
	WELCOME("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
	INVALID_INPUT("Please select a valid option!"),
	BOOK_CHECK_OUT_SUCCESS("Thank you! Enjoy the book"),
	BOOK_CHECK_OUT_FAILURE("Sorry, that book is not available"),
	BOOK_RETURN_SUCCESS("Thank you for returning the book"),
	BOOK_RETURN_FAILURE("That is not a valid book to return."),
	NO_BOOKS_AVAILABLE("No Books are Available in Library Now!"),
	NO_MOVIES_AVAILABLE("No Movies are Available Now!"),
	MOVIE_CHECK_OUT_SUCCESS("Thank you! Enjoy the movie"),
	MOVIE_CHECK_OUT_FAILURE("Sorry, that movie is not available");
	String message;

	Notifications(String message) {
		this.message = message;
	}

	public void showNotificationOn(PrintStream out) {
		out.println(message);
	}
}
