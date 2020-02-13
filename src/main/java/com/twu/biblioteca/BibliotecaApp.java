package com.twu.biblioteca;

public class BibliotecaApp {
	private static SystemWrapper systemWrapper;
	private static Menu menu;
	private static Library library;
	private static MoviesLibrary moviesLibrary;

	public static void main(String[] args) {

		Notifications.WELCOME.showNotificationOn(System.out);

		setUpDependencies();
		SystemController coreSystemController = new SystemController(menu, library, moviesLibrary, systemWrapper);

		coreSystemController.startSession();
	}

	private static void setUpDependencies() {
		systemWrapper = new SystemWrapper(System.in, System.out);
		menu = new Menu(systemWrapper.getPrintStream());
		Librarian librarian = new Librarian();
		library = new Library(librarian, systemWrapper.getPrintStream());
		moviesLibrary = new MoviesLibrary(systemWrapper);
	}
}
