package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.NoBookAvailableException;

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

	public void showDetailsOfBooks() throws NoBookAvailableException {
		if (hasBooks()) {
			System.out.println("\n[+] Listing Down All The Library Books :-");
			System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
			for (Book book : availableBookList) {
				book.printDetails(printStream);
			}
			return;
		}
		throw new NoBookAvailableException();
	}

	public void checkOutRequest(Book queriedBook) {
		if (availableBookList.contains(queriedBook)) {
			librarian.acceptCheckOutRequest(queriedBook);
			availableBookList.remove(queriedBook);
			Notifications.CHECK_OUT_SUCCESS.showNotificationOn(printStream);
			return;
		}
		Notifications.CHECK_OUT_FAILURE.showNotificationOn(printStream);
	}

	public void returnBookRequest(Book bookToBeReturned) {
		if (!librarian.hasAvailableForCheckOut(bookToBeReturned)) {
			librarian.acceptReturnRequest(bookToBeReturned);
			Notifications.RETURN_SUCCESS.showNotificationOn(printStream);
			availableBookList.add(bookToBeReturned);
			return;
		}
		Notifications.RETURN_FAILURE.showNotificationOn(printStream);
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
