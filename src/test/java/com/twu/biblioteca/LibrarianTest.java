package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.NoBookAvailableException;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibrarianTest {

	@Test
	void testShouldReturnTrueIfABookIsAvailableForCheckedOut() {
		Librarian librarian = new Librarian();

		Book bookToBeCheckedOut = new Book("Random Book", "Random Author", 2020);

		assertTrue(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}

	@Test
	void testShouldReturnFalseIfABookIsNotAvailableForCheckedOut() {
		Librarian librarian = new Librarian();
		Book bookToBeCheckedOut = new Book("Random Book", "Random Author", 2020);

		librarian.acceptCheckOutRequest(bookToBeCheckedOut, mock(User.class));

		assertFalse(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}

	@Test
	void testShouldMoveABookToCheckedOutBookList() throws NoBookAvailableException {
		Librarian librarian = new Librarian();
		Library library = new Library(librarian, System.out);
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Book bookToBeCheckedOut = new Book("Harry Potter", "J K Rowling", 2012);

		librarian.acceptCheckOutRequest(bookToBeCheckedOut, mock(User.class));
		library.showDetailsOfBooks();

		assertFalse(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}

	@Test
	void testShouldNotShowAnAlreadyCheckedOutBookInAvailableBookList() throws NoBookAvailableException {
		Librarian librarian = new Librarian();
		Library library = new Library(librarian, System.out);
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Book bookToBeCheckedOut = new Book("Harry Potter", "J K Rowling", 2012);

		librarian.acceptCheckOutRequest(bookToBeCheckedOut, mock(User.class));
		library.showDetailsOfBooks();

		verify(mockPrintStream, times(0)).println("Harry Potter\tJ K Rowling\t\t2012");

	}

	@Test
	void testShouldBeAbleReturnAValidCheckedOutBook() throws NoBookAvailableException {
		Librarian librarian = new Librarian();
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(librarian, mockPrintStream);
		Book bookToBeCheckedOut = new Book("Harry Potter", "J K Rowling", 2012);
		librarian.acceptCheckOutRequest(bookToBeCheckedOut, mock(User.class));

		librarian.acceptReturnRequest(bookToBeCheckedOut, null);
		library.showDetailsOfBooks();

		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
	}

	@Test
	void testShouldReturnALogBookOfCheckOutTransactionsDoneByUser() {
		Librarian librarian = new Librarian();
		SystemWrapper systemWrapper = new SystemWrapper(System.in, System.out);
		Library library = new Library(librarian, systemWrapper.getPrintStream());
		Book bookToBeCheckedOut = new Book("Harry Potter", "J K Rowling", 2012);
		User user = new User("123-4567", "1234", null, null, null);
		HashMap<Book, User> expectedLogBook = new HashMap<>();
		expectedLogBook.put(bookToBeCheckedOut, user);

		librarian.acceptCheckOutRequest(bookToBeCheckedOut, user);


		assertEquals(expectedLogBook, librarian.getLogBookOfCheckOuts());
	}
}
