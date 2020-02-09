package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

import java.util.Scanner;

public class SystemController {
	private Library library;
	private Menu menu;

	SystemController(Menu menu, Library library) {
		this.library = library;
		this.menu = menu;
	}

	public void displayMenu() {
		menu.showOptions();
	}

	private int acceptInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public void serveUserIntent() throws ExitFromApplicationException {
		int option = acceptInput();

		switch (option) {
			case 1:
				library.showBookDetails();
				break;
			case 2:
				throw new ExitFromApplicationException();    // Eventually will be replaced by	->	System.exit(0);
			default:
				System.out.println("Please select a valid option!");
		}
	}
}
