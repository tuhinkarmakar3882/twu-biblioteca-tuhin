package com.twu.biblioteca;

public class BibliotecaApp {

	public static void main(String[] args) {

		Notifications.WELCOME.showNotificationOn(System.out);

		SystemController coreSystemController = new SystemController(new Menu(), new Library(new Librarian(), System.out), System.out);

		coreSystemController.startSession();

	}
}
