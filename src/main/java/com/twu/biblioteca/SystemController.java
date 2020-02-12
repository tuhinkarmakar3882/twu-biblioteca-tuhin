package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

import java.io.PrintStream;

public class SystemController {
	private Library library;
	private Menu menu;
	private SystemWrapper systemWrapper;
	private PrintStream outStream;


	SystemController(Menu menu, Library library, PrintStream outStream) {
		this.library = library;
		this.menu = menu;
		this.outStream = outStream;
		systemWrapper = new SystemWrapper();
	}

	public void displayMenu() {
		menu.showOptions();
	}

	public void serveUserRequest() throws ExitFromApplicationException {
		String option = systemWrapper.nextLine();
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
				systemWrapper.closeSession();
			}
		}
	}
}
