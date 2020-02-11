package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.NoBookAvailableException;

import java.util.Map;
import java.util.Scanner;

import static java.util.Map.of;

public enum Service {

	EXIT_SYSTEM {
		@Override
		public void serveIntent(Library library) throws ExitFromApplicationException {
			throw new ExitFromApplicationException();
			//System.exit(0);
		}
	},
	DISPLAY_BOOKS {
		@Override
		public void serveIntent(Library library) {
			try {
				library.showDetailsOfBooks();
			} catch (NoBookAvailableException exception) {
				Notifications.NO_BOOK_AVAILABLE.showNotificationOn(System.out);
			}
		}
	},
	RAISE_A_CHECKOUT_REQUEST {
		@Override
		public void serveIntent(Library library) {
			Book queriedBook = getUserQueriedBook();
			library.checkOutRequest(queriedBook);
		}
	},
	RAISE_A_RETURN_REQUEST {
		@Override
		public void serveIntent(Library library) {
			Book bookToBeReturned = getUserQueriedBook();
			library.returnBookRequest(bookToBeReturned);
		}
	};


	public static Service getRequestedService(String option) {
		Map<String, Service> listOfAllServices = of(
				"0", EXIT_SYSTEM,
				"1", DISPLAY_BOOKS,
				"2", RAISE_A_CHECKOUT_REQUEST,
				"3", RAISE_A_RETURN_REQUEST
		);
		return listOfAllServices.get(option);
	}

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