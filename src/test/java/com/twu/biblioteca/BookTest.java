package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookTest {
	@Test
	void testShouldCompareTwoBooks() {
		Book book = new Book("A Good Book");

		assertEquals(new Book("A Good Book"), book);
	}

	@Test
	void testShouldPrintTheBookDetails() {
		Book book = new Book("A Good Book");
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);

		book.printDetails();

		verify(mockPrintStream, times(1)).println("A Good Book");
	}
}