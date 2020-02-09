package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

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

		librarian.checkOutBook(bookToBeCheckedOut);

		assertFalse(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}

	@Test
	void testShouldMoveABookToCheckedOutBookList() {
		Librarian librarian = new Librarian();
		Library library = new Library(librarian);
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Book bookToBeCheckedOut = library.getBooks().get(0);

		librarian.checkOutBook(bookToBeCheckedOut);
		library.showDetailsOfBooks();

		assertFalse(librarian.hasAvailableForCheckOut(bookToBeCheckedOut));
	}
}
