package com.twu.biblioteca;

import java.util.Scanner;

public class SystemController {
	private Library library;
	private Menu menu;

	SystemController(Library library, Menu menu) {
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
		switch (option) {
			case 1:
				library.showBookDetails();
				break;
		}
	}

}
