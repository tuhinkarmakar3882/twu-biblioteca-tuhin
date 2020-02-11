package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class SystemControllerTest {
	Library library;
	Menu menu;
	SystemController systemController;
	PrintStream mockPrintStream;

	@BeforeEach
	void setup() {
		library = mock(Library.class);
		menu = mock(Menu.class);
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		systemController = new SystemController(menu, library, mockPrintStream);
	}

	@Test
	public void testShouldDisplayTheMenuList() {
		systemController.displayMenu();

		verify(menu, times(1)).showOptions();
	}

}