package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
	private final ArrayList<Book> availableBookList;
	private final Librarian librarian;
	private PrintStream printStream;

	public Library(Librarian librarian, PrintStream printStream) {
		this.librarian = librarian;
		this.availableBookList = initializeWithBooks();
		this.printStream = printStream;
	}

	public void showDetailsOfBooks() {
		if (hasBooks()) {
			System.out.println("\n[+] Listing Down All The Library Books :-");
			System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
			for (Book book : availableBookList) {
				book.printDetails(printStream);
			}
			return;
		}
		Notifications.NO_BOOKS_AVAILABLE.showNotificationOn(System.out);
	}

	public void checkOutRequest(Book queriedBook) {
		if (availableBookList.contains(queriedBook)) {
			librarian.acceptCheckOutRequest(queriedBook);
			availableBookList.remove(queriedBook);
			Notifications.BOOK_CHECK_OUT_SUCCESS.showNotificationOn(printStream);
			return;
		}
		Notifications.BOOK_CHECK_OUT_FAILURE.showNotificationOn(printStream);
	}

	public void returnBookRequest(Book bookToBeReturned) {
		if (!librarian.hasAvailableForCheckOut(bookToBeReturned)) {
			librarian.acceptReturnRequest(bookToBeReturned);
			Notifications.BOOK_RETURN_SUCCESS.showNotificationOn(printStream);
			availableBookList.add(bookToBeReturned);
			return;
		}
		Notifications.BOOK_RETURN_FAILURE.showNotificationOn(printStream);
	}

	private ArrayList<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		Book secondBook = new Book("Learn Python", "Geeks4Geeks", 2019);
		return new ArrayList<>(Arrays.asList(firstBook, secondBook));
	}

	private boolean hasBooks() {
		return availableBookList.size() > 0;
	}
}
