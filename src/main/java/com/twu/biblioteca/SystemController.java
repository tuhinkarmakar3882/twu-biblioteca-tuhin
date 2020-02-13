package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.UserDoesNotExists;

public class SystemController {
	private Library library;
	private MoviesLibrary moviesLibrary;
	private Menu menu;
	private SystemWrapper systemWrapper;
	public static CredentialAuthenticator credentialAuthenticator;


	SystemController(Menu menu, Library library, MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
		this.library = library;
		this.menu = menu;
		this.moviesLibrary = moviesLibrary;
		this.systemWrapper = systemWrapper;
		credentialAuthenticator = new CredentialAuthenticator();
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

				case "USER":
					chosenMenuItem.performAssociatedAction(credentialAuthenticator.authenticateUserVia(systemWrapper), systemWrapper);
					break;
			}
			return;
		}

		Notifications.INVALID_INPUT.showNotificationOn(systemWrapper.getPrintStream());
	}

	public void startSession() {
		while (true) {
			displayMenu();
			try {
				serveUserRequest();
			} catch (ExitFromApplicationException exitRequest) {
				systemWrapper.closeSession();
			} catch (Exception unhandledExceptions) {
				throw new RuntimeException();
			}
		}
	}
}
