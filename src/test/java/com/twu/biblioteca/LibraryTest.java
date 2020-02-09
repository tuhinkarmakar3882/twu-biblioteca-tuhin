package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryTest {
	@Test
	public void testShouldReturnTheLibraryBooks() {
		List<Book> expectedBooks = new ArrayList<>(Collections.singletonList(new Book("Harry Potter", "J K Rowling", 2012)));

		Library library = new Library();

		assertEquals(expectedBooks, library.getBooks());
	}

	@Test
	public void testShouldPrintDetailsOfTheLibraryBooks() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library();

		library.showBookDetails();

		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
	}
}
