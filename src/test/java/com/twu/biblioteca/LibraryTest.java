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
		Library library = new Library(mockPrintStream);

		library.showDetailsOfBooks();

		verify(mockPrintStream, times(1)).println("\n[+] Listing Down All The Library Books :-");
		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulCheckOut() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);

		library.checkOutRequest(book, mock(User.class));

		library.showDetailsOfBooks();
		verify(mockPrintStream, times(1)).println("Thank you! Enjoy the book");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheBookIsUnavailable() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);
		library.checkOutRequest(book, mock(User.class));

		library.checkOutRequest(book, mock(User.class));

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheSpellingIsWrong() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		Book book = new Book("HOrrI PittAr", "J K Rowling", 2012);

		library.checkOutRequest(book, mock(User.class));

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulReturn() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);
		User user = mock(User.class);
		library.checkOutRequest(book, user);

		library.returnBookRequest(book, user);

		verify(mockPrintStream, times(1)).println("Thank you for returning the book");
	}

	@Test
	public void testShouldNotifyAfterFailedBookReturnDueToSpellingError() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		User user = mock(User.class);
		Book correctBook = new Book("Harry Potter", "J K Rowling", 2012);
		library.checkOutRequest(correctBook, user);
		Book incorrectBook = new Book("HOrrI PIttAr", "J K Rowling", 2012);

		library.returnBookRequest(incorrectBook, user);

		verify(mockPrintStream, times(1)).println("Thank you! Enjoy the book");
		verify(mockPrintStream, times(1)).println("That is not a valid book to return.");
	}


	@Test
	public void testShouldAllowValidUserToReturnItsBook() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(mockPrintStream);
		Book book = new Book("Harry Potter", "J K Rowling", 2012);
		User userOne = mock(User.class);
		library.checkOutRequest(book, userOne);

		library.returnBookRequest(book, userOne);

		verify(mockPrintStream, times(1)).println("Thank you for returning the book");
	}


}
