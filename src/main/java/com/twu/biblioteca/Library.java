package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Library {
	private List<Book> bookList;
	private Librarian librarian;

	public Library(Librarian librarian) {
		this.librarian = librarian;
		this.bookList = initializeWithBooks();
	}

	public void showDetailsOfBooks() {
		System.out.println("[+] Listing Down All The Library Books :-");
		System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
		for (Book book : bookList) {
			if (librarian.hasAvailableForCheckOut(book)) {
				book.printDetails();
			}
		}
	}

	public void checkOutRequest() {
		Book queriedBook = getUserQueriedBook();
		if (librarian.hasAvailableForCheckOut(queriedBook) && bookList.contains(queriedBook)) {
			librarian.checkOutBook(queriedBook);
			Notifications.CheckOutSuccess.showNotification();
			return;
		}
		Notifications.CheckOutFailure.showNotification();
	}

	public void returnBookRequest() {
		Book bookToBeReturned = getUserQueriedBook();
		if (!librarian.hasAvailableForCheckOut(bookToBeReturned)) {
			librarian.returnBook(bookToBeReturned);
			Notifications.ReturnSuccess.showNotification();
			return;
		}
		Notifications.ReturnFailure.showNotification();
	}

	private List<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		Book secondBook = new Book("Learn Python", "Geeks4Geeks", 2019);
		return Arrays.asList(firstBook, secondBook);
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
