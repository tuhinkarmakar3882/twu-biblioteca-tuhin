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
		System.out.println("[+] Listing Down All The Library Books :-");

		System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
		for (Book book : bookList) {
			book.printDetails();
		}
	}

	private List<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		return Collections.singletonList(firstBook);
	}

}
