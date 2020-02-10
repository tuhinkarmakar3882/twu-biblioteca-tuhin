package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
	private final ArrayList<Book> availableBookList;
	private final Librarian librarian;

	public Library(Librarian librarian) {
		this.librarian = librarian;
		this.availableBookList = initializeWithBooks();
	}

	public void showDetailsOfBooks() {
		System.out.println("[+] Listing Down All The Library Books :-");
		System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
		for (Book book : availableBookList) {
			if (librarian.hasNotAvailableForReturn(book)) {
				book.printDetails();
			}
		}
	}

	public void checkOutRequest() {
		Book queriedBook = getUserQueriedBook();
		if (availableBookList.contains(queriedBook)) {
			librarian.acceptCheckOutRequest(queriedBook);
			Notifications.CheckOutSuccess.showNotification();
			availableBookList.remove(queriedBook);
			return;
		}
		Notifications.CheckOutFailure.showNotification();
	}

	public void returnBookRequest() {
		Book bookToBeReturned = getUserQueriedBook();
		if (!librarian.hasNotAvailableForReturn(bookToBeReturned)) {
			librarian.acceptReturnRequest(bookToBeReturned);
			Notifications.ReturnSuccess.showNotification();
			availableBookList.add(bookToBeReturned);
			return;
		}
		Notifications.ReturnFailure.showNotification();
	}

	private ArrayList<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		Book secondBook = new Book("Learn Python", "Geeks4Geeks", 2019);
		return new ArrayList<>(Arrays.asList(firstBook, secondBook));
	}

	private Book getUserQueriedBook() {
		System.out.println("[+] Book Check out Request");
		Scanner scanner = new Scanner(System.in);

		System.out.println("\t[+] Book Name : ");
		String bookName = scanner.nextLine();
		System.out.println("\t[+] Author Name : ");
		String authorName = scanner.nextLine();
		System.out.println("\t[+] Publication Year : ");
		int publicationYear = scanner.nextInt();

		return new Book(bookName, authorName, publicationYear);
	}

}
