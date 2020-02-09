package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
}