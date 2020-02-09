package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class MenuTest {
	PrintStream mockPrintStream;

	@BeforeEach
	public void setup() {
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
	}

	@Test
	public void testShouldCreateAMenuAndDisplayItsOptions() {
		Menu menu = new Menu();
		String expectedWelcomeMessage = "List of book";

		menu.showOptions();

		verify(mockPrintStream, times(1)).println(expectedWelcomeMessage);
	}
}
