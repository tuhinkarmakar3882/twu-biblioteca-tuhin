package com.twu.biblioteca;

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

	public void serveUserIntent() {
		int option = acceptInput();

		if (option == 1) {
			library.showBookDetails();
		} else {
			System.out.println("Please select a valid option!");
		}
	}

}
