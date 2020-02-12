package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

	public static void main(String[] args) {

		Notifications.WELCOME.showNotificationOn(System.out);

		PrintStream outStream = System.out;
		Menu menu = new Menu(outStream);
		Librarian librarian = new Librarian();
		Library library = new Library(librarian, outStream);
		MoviesLibrary moviesLibrary = new MoviesLibrary(outStream);


		SystemController coreSystemController = new SystemController(menu, library, moviesLibrary, outStream);

		coreSystemController.startSession();
	}
}
