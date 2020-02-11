package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.NoBookAvailableException;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

		librarian.acceptCheckOutRequest(bookToBeCheckedOut);

		assertFalse(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}

	@Test
	void testShouldMoveABookToCheckedOutBookList() throws NoBookAvailableException {
		Librarian librarian = new Librarian();
		Library library = new Library(librarian, System.out);
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Book bookToBeCheckedOut = new Book("Harry Potter", "J K Rowling", 2012);

		librarian.acceptCheckOutRequest(bookToBeCheckedOut);
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

		librarian.acceptCheckOutRequest(bookToBeCheckedOut);
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
		librarian.acceptCheckOutRequest(bookToBeCheckedOut);

		librarian.acceptReturnRequest(bookToBeCheckedOut);
		library.showDetailsOfBooks();

		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
	}

}
