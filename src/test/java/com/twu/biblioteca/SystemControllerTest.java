package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
	public void testShouldDisplayAListOfLibraryBooksIfThatOptionIsSelectedFromMenu() throws ExitFromApplicationException {
		String inputChoice = "1";
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);
		systemController.displayMenu();

		systemController.serveUserIntent();

		verify(library, times(1)).showDetailsOfBooks();
	}

	@Test
	public void testShouldDisplayANotificationIfInvalidInputIsGiven() throws ExitFromApplicationException {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		String expectedNotificationMessage = "Please select a valid option!";
		String inputChoice = "-1";        //Invalid Input
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);

		systemController.displayMenu();

		systemController.serveUserIntent();

		verify(library, times(0)).showDetailsOfBooks();
		verify(mockPrintStream, times(1)).println(expectedNotificationMessage);
	}

	@Test
	public void testShouldTerminateIfExitOptionIsChosen() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		String inputChoice = "3";
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);

		systemController.displayMenu();

		assertThrows(ExitFromApplicationException.class, () -> systemController.serveUserIntent());
	}

	@Test
	public void testShouldRaiseACheckOutRequest() throws ExitFromApplicationException {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		String inputChoice = "2";
		InputStream in = new ByteArrayInputStream(inputChoice.getBytes());
		System.setIn(in);

		systemController.displayMenu();
		systemController.serveUserIntent();

		verify(library, times(1)).checkOutRequest();
	}
}