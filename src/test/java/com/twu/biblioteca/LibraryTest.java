package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.NoBookAvailableException;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class LibraryTest {

	@Test
	public void testShouldPrintDetailsOfTheLibraryBooks() throws NoBookAvailableException {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), mockPrintStream);

		library.showDetailsOfBooks();

		verify(mockPrintStream, times(1)).println("\n[+] Listing Down All The Library Books :-");
		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulCheckOut() throws NoBookAvailableException {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);

		library.checkOutRequest(book);

		library.showDetailsOfBooks();
		verify(mockPrintStream, times(1)).println("Thank you! Enjoy the book");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheBookIsUnavailable() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);
		library.checkOutRequest(book);

		library.checkOutRequest(book);

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheSpellingIsWrong() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), mockPrintStream);
		Book book = new Book("HOrrI PittAr", "J K Rowling", 2012);

		library.checkOutRequest(book);

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulReturn() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);

		library.checkOutRequest(book);

		library.returnBookRequest(book);

		verify(mockPrintStream, times(1)).println("Thank you for returning the book");
	}

	@Test
	public void testShouldNotifyAfterFailedBookReturnDueToSpellingError() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian(), System.out);

		Book book = new Book("HOrrI PIttAr", "J K Rowling", 2012);

		library.returnBookRequest(book);

		verify(mockPrintStream, times(1)).println("That is not a valid book to return.");
	}
}
