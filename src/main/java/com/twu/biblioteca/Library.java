package com.twu.biblioteca;

import java.util.Collections;
import java.util.List;

public class Library {
	private final List<Book> bookList;

	public Library() {
		this.bookList = initializeWithBooks();
	}

	public List<Book> getBooks() {
		return bookList;
	}

	public void showBookDetails() {
		for (Book book : bookList) {
			book.printDetails();
		}
	}

	private List<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter");
		return Collections.singletonList(firstBook);
	}


}
