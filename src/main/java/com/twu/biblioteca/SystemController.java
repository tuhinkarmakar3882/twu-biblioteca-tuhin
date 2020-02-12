package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

public class SystemController {
	private Library library;
	private MoviesLibrary moviesLibrary;
	private Menu menu;
	private SystemWrapper systemWrapper;

	SystemController(Menu menu, Library library, MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
		this.library = library;
		this.menu = menu;
		this.moviesLibrary = moviesLibrary;
		this.systemWrapper = systemWrapper;
	}

	public void displayMenu() {
		menu.showOptions();
	}

	public void serveUserRequest() throws ExitFromApplicationException {
		String option = systemWrapper.nextLine();

		if (menu.isValidOption(option)) {

			MenuItem chosenMenuItem = menu.getMenuItem(option);

			switch (chosenMenuItem.getTypeOfService()) {

				case "LIBRARY":
					chosenMenuItem.performAssociatedAction(library);
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
			}
		}
	}
}
