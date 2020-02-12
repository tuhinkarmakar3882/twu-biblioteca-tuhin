package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.UserDoesNotExists;

public class SystemController {
	private Library library;
	private MoviesLibrary moviesLibrary;
	private Menu menu;
	private SystemWrapper systemWrapper;
	private User user;

	SystemController(Menu menu, Library library, MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
		this.library = library;
		this.menu = menu;
		this.moviesLibrary = moviesLibrary;
		this.systemWrapper = systemWrapper;
	}

	public void displayMenu() {
		menu.showOptions();
	}

	public void serveUserRequest() throws ExitFromApplicationException, UserDoesNotExists {
		String option = systemWrapper.takeInput();

		if (menu.isValidOption(option)) {

			MenuItem chosenMenuItem = menu.getMenuItem(option);

			switch (chosenMenuItem.getTypeOfService()) {

				case "LIBRARY":
					chosenMenuItem.performAssociatedAction(library, systemWrapper);
					break;

				case "MOVIES":
					chosenMenuItem.performAssociatedAction(moviesLibrary, systemWrapper);
					break;
			}
			return;
		}

		Notifications.INVALID_INPUT.showNotificationOn(systemWrapper.getPrintStream());
	}

	public void startSession() {
//		int a=0;
		while (true) {
			displayMenu();
			try {
				serveUserRequest();
			} catch (ExitFromApplicationException exitRequest) {
				systemWrapper.closeSession();
			} catch (Exception unhandledExceptions) {
				throw new RuntimeException();
//				systemWrapper.getPrintStream().println("INVALID CREDENTIALS! USER DOES NOT EXISTS.");
			}
		}
	}
}
