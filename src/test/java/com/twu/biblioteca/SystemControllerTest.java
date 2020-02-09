package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

class SystemControllerTest {
	Library library;
	Menu menu;
	SystemController systemController;

	@BeforeEach
	void setup() {
		library = mock(Library.class);
		menu = mock(Menu.class);
		systemController = new SystemController(menu, library);
	}

	@Test
	public void testShouldDisplayAListOfLibraryBooksIfThatOptionIsSelectedFromMenu() {
		String inputChoice = "1";
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);
		systemController.displayMenu();

		systemController.serveUserIntent();

		verify(library, times(1)).showBookDetails();
	}

	@Test
	public void testShouldDisplayANotificationIfInvalidInputIsGiven() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		String expectedNotificationMessage = "Please select a valid option!";
		String inputChoice = "-1";        //Invalid Input
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);
		systemController.displayMenu();

		systemController.serveUserIntent();

		verify(library, times(0)).showBookDetails();
		verify(mockPrintStream, times(1)).println(expectedNotificationMessage);

	}
}