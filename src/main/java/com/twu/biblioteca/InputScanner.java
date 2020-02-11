package com.twu.biblioteca;

import java.util.Scanner;

public class InputScanner {
	private Scanner scanner;

	public InputScanner() {
		this.scanner = new Scanner(System.in);
	}

	public String nextLine() {
		return scanner.nextLine();
	}
}
