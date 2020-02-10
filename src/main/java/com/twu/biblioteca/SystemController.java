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

	public void serveUserIntent() throws ExitFromApplicationException {
		String option = acceptInput();

		switch (option) {
			case "0":
				throw new ExitFromApplicationException();    // Eventually will be replaced by->	System.exit(0);

			case "1":
				library.showDetailsOfBooks();
				break;

			case "2":
				library.checkOutRequest();
				break;

			case "3":
				library.returnBookRequest();
				break;

			default:
				System.out.println("Please select a valid option!");
		}
	}

	private String acceptInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
