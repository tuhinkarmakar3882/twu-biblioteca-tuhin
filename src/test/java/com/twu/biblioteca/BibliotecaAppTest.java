package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class BibliotecaAppTest {
	PrintStream mockPrintStream;

	@BeforeEach
	public void setup() {
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
	}

	@Test
	public void testShouldPrintAWelcomeMessageWheneverTheApplicationStarts() {
		String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

		BibliotecaApp.main(null);

		verify(mockPrintStream, times(1)).println(expectedWelcomeMessage);
	}

	@Test
	public void testShouldPrintTheBookDetailsAfterAWelcomeMessageWheneverTheApplicationStarts() {
		String expectedBookDetails = "Harry Potter\tJ K Rowling\t\t2012";

		BibliotecaApp.main(null);

		verify(mockPrintStream, times(1)).println(expectedBookDetails);
	}
}