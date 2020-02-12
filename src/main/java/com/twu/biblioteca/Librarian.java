package com.twu.biblioteca;

import java.util.HashMap;
import java.util.HashSet;

public class Librarian {
	private final HashSet<Book> checkedOutBooks;
	private HashMap<User, Book> logBookOfCheckOuts;

	public Librarian() {
		this.checkedOutBooks = new HashSet<>();
		this.logBookOfCheckOuts = new HashMap<>();
	}

	public void acceptCheckOutRequest(Book book, User user) {
		checkedOutBooks.add(book);
		logBookOfCheckOuts.put(user, book);
	}

	public boolean hasAvailableForCheckOut(Book book) {
		return !checkedOutBooks.contains(book);
	}

	public void acceptReturnRequest(Book book) {
		checkedOutBooks.remove(book);
	}

	public HashMap<User, Book> getLogBookOfCheckOuts() {
		return logBookOfCheckOuts;
	}
}