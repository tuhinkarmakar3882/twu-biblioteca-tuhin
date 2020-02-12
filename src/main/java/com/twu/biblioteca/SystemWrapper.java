package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemWrapper {
	private Scanner scanner;
	private InputStream inputStream;
	private PrintStream printStream;

	public SystemWrapper(InputStream inputStream, PrintStream printStream) {
		this.inputStream = inputStream;
		this.printStream = printStream;
		scanner = new Scanner(inputStream);
	}

	public String nextLine() {
		return scanner.nextLine();
	}

	public void closeSession() {
		System.exit(0);
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public PrintStream getPrintStream() {
		return printStream;
	}
}
