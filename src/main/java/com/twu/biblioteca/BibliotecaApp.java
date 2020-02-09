package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

public class BibliotecaApp {

	public static void main(String[] args) {
		WelcomeScreen welcomeScreen = new WelcomeScreen("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
		welcomeScreen.showMessage();

		SystemController systemController = new SystemController(new Menu(), new Library(new Librarian()));
		while (true) {
			systemController.displayMenu();
			try {
				systemController.serveUserIntent();
			} catch (ExitFromApplicationException exitRequest) {
				System.exit(0);
			}
		}
	}
}
