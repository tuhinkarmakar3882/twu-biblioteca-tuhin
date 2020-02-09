package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookTest {
	@Test
	public void testShouldCompareTwoBooks() {
		Book book = new Book("Harry Potter", "J K Rowling", 2012);

		assertEquals(new Book("Harry Potter", "J K Rowling", 2012), book);
	}

	@Test
	public void testShouldPrintTheBookDetails() {
		Book book = new Book("Harry Potter", "J K Rowling", 2012);
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);

		book.printDetails();

		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
	}
}