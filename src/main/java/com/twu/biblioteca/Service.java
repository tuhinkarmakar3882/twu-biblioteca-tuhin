package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.UserDoesNotExists;

public abstract class Service {

	public static final Service EXIT_SYSTEM = new Service() {
		@Override
		public void serveIntent(Library library, SystemWrapper systemWrapper) throws ExitFromApplicationException {
			throw new ExitFromApplicationException();
		}
	};

	public static final Service DISPLAY_BOOKS = new Service() {
		@Override
		public void serveIntent(Library library, SystemWrapper systemWrappers) {
			library.showDetailsOfBooks();

		}
	};

	public static final Service RAISE_A_CHECKOUT_REQUEST = new Service() {
		@Override
		public void serveIntent(Library library, SystemWrapper systemWrapper) throws UserDoesNotExists {
			User authenticatedUser = SystemController.credentialAuthenticator.authenticateUserVia(systemWrapper);
			Book queriedBook = getUserQueriedBook(systemWrapper);
			library.checkOutRequest(queriedBook, authenticatedUser);
		}
	};


	public static final Service RAISE_A_RETURN_REQUEST = new Service() {
		@Override
		public void serveIntent(Library library, SystemWrapper systemWrapper) throws UserDoesNotExists {
			User authenticatedUser = SystemController.credentialAuthenticator.authenticateUserVia(systemWrapper);
			Book bookToBeReturned = getUserQueriedBook(systemWrapper);
			library.returnBookRequest(bookToBeReturned, authenticatedUser);
		}
	};

	public abstract void serveIntent(Library library, SystemWrapper systemWrapper) throws ExitFromApplicationException, UserDoesNotExists;

	private static Book getUserQueriedBook(SystemWrapper systemWrapper) {
		System.out.println("[+] Book Check out Request");

		System.out.println("\t[+] Book Name : ");
		String bookName = systemWrapper.takeInput();
		System.out.println("\t[+] Author Name : ");
		String authorName = systemWrapper.takeInput();
		System.out.println("\t[+] Publication Year : ");
		String publicationYearString = systemWrapper.takeInput();

		try {
			int publicationYear = Integer.parseInt(publicationYearString); // try to convert the string into Integer
			return new Book(bookName, authorName, publicationYear);
		} catch (NumberFormatException invalidNumber) {
			return new Book(bookName, authorName, -1); //ForceFully Making it an InValid Book
		}

	}
}