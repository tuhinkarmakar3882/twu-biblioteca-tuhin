package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

import java.io.PrintStream;

public class SystemController {
	private Library library;
	private Menu menu;
	private InputScanner inputScanner;
	private PrintStream outStream;


	SystemController(Menu menu, Library library, PrintStream outStream) {
		this.library = library;
		this.menu = menu;
		this.outStream = outStream;
		inputScanner = new InputScanner();
	}

	public void displayMenu() {
		menu.showOptions();
	}

	public void serveUserRequest() throws ExitFromApplicationException {
		String option = inputScanner.nextLine();
		if (menu.isValidOption(option)) {
			Service requestedService = Service.getRequestedService(option);
			requestedService.serveIntent(library);
		} else {
			Notifications.INVALID_INPUT.showNotificationOn(outStream);
		}
	}

	public void startSession() {
		while (true) {
			displayMenu();
			try {
				serveUserRequest();
			} catch (ExitFromApplicationException exitRequest) {
				System.exit(0);
			}
		}
	}
}
