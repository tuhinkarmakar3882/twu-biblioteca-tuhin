package com.twu.biblioteca;

import java.util.Scanner;

public class SystemWrapper {
	private Scanner scanner;

	public SystemWrapper() {
		this.scanner = new Scanner(System.in);
	}

	public String nextLine() {
		return scanner.nextLine();
	}


	public void closeSession() {
		System.exit(0);
	}


}
