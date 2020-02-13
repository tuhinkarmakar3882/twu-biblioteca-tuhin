package com.twu.biblioteca;

import java.util.HashMap;
import java.util.HashSet;

public class Librarian {
	private final HashSet<Book> checkedOutBooks;
	private HashMap<Book, User> logBookOfCheckOuts;

	public Librarian() {
		this.checkedOutBooks = new HashSet<>();
		this.logBookOfCheckOuts = new HashMap<>();
	}

	public void acceptCheckOutRequest(Book book, User user) {
		checkedOutBooks.add(book);
		logBookOfCheckOuts.put(book, user);
	}

	public boolean hasAvailableForCheckOut(Book book) {
		return !checkedOutBooks.contains(book);
	}

	public void acceptReturnRequest(Book book, User user) {
		checkedOutBooks.remove(book);
		logBookOfCheckOuts.remove(book);
	}

	public HashMap<Book, User> getLogBookOfCheckOuts() {
		return logBookOfCheckOuts;
	}

	public boolean hasAvailableForReturn(Book bookToBeReturned, User user) {

		if (checkedOutBooks.contains(bookToBeReturned)) {
			return (logBookOfCheckOuts.get(bookToBeReturned).equals(user));
		}
		return false;
	}
}