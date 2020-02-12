package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

import java.util.Scanner;

public abstract class Service {

	public static final Service EXIT_SYSTEM = new Service() {
		@Override
		public void serveIntent(Library library) throws ExitFromApplicationException {
			throw new ExitFromApplicationException();
		}
	};

	public static final Service DISPLAY_BOOKS = new Service() {
		@Override
		public void serveIntent(Library library) {
			library.showDetailsOfBooks();

		}
	};

	public static final Service RAISE_A_CHECKOUT_REQUEST = new Service() {
		@Override
		public void serveIntent(Library library) {
			Book queriedBook = getUserQueriedBook();
			library.checkOutRequest(queriedBook);
		}
	};


	public static final Service RAISE_A_RETURN_REQUEST = new Service() {
		@Override
		public void serveIntent(Library library) {
			Book bookToBeReturned = getUserQueriedBook();
			library.returnBookRequest(bookToBeReturned);
		}
	};

	private static Book getUserQueriedBook() {
		System.out.println("[+] Book Check out Request");
		Scanner scanner = new Scanner(System.in);

		System.out.println("\t[+] Book Name : ");
		String bookName = scanner.nextLine();
		System.out.println("\t[+] Author Name : ");
		String authorName = scanner.nextLine();
		System.out.println("\t[+] Publication Year : ");
		String publicationYearString = scanner.nextLine();

		try {
			int publicationYear = Integer.parseInt(publicationYearString);
			return new Book(bookName, authorName, publicationYear);
		} catch (NumberFormatException invalidNumber) {
			return new Book(bookName, authorName, -1); //ForceFully Making it an InValid Book
		}

	}

	public abstract void serveIntent(Library library) throws ExitFromApplicationException;
}