package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryTest {
	@Test
	void testShouldReturnTheLibraryBooks() {
		List<Book> expectedBooks = new ArrayList<>(Collections.singletonList(new Book("Harry Potter")));

		Library library = new Library();

		assertEquals(expectedBooks, library.getBooks());
	}

	@Test
	void testShouldPrintDetailsOfTheLibraryBooks() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library();

		library.showBookDetails();

		verify(mockPrintStream, times(1)).println("Harry Potter");
	}
}
