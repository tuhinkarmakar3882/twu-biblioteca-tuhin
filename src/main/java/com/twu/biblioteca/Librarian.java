package com.twu.biblioteca;

import java.util.HashSet;

public class Librarian {
	private final HashSet<Book> checkedOutBooks;

	public Librarian() {
		this.checkedOutBooks = new HashSet<>();
	}

	public void acceptCheckOutRequest(Book book) {
		checkedOutBooks.add(book);
	}

	public boolean hasAvailableForCheckOut(Book book) {
		return !checkedOutBooks.contains(book);
	}

	public void acceptReturnRequest(Book book) {
		checkedOutBooks.remove(book);
	}
}