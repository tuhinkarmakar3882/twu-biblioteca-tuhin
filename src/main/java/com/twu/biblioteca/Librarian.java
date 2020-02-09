package com.twu.biblioteca;

import java.util.HashSet;

public class Librarian {
	private HashSet<Book> checkedOutBooks;

	public Librarian() {
		this.checkedOutBooks = new HashSet<>();
	}

	public void checkOutBook(Book book) {
		checkedOutBooks.add(book);
	}

	public boolean hasAvailableForCheckOut(Book book) {
		return !checkedOutBooks.contains(book);
	}

	public void returnBook(Book book) {
		checkedOutBooks.remove(book);
	}
}