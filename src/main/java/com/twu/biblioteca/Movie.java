package com.twu.biblioteca;

import java.io.PrintStream;

public class Movie {
	private String name;
	private String directorName;
	private String rating;
	private int year;

	public Movie(String name, String directorName, int year, String rating) {
		this.name = name;
		this.directorName = directorName;
		this.year = year;
		this.rating = rating;
	}

	public void printDetails(PrintStream outStream) {
		String separateWith = " | ";
		outStream.println(name + separateWith + directorName + separateWith + year + separateWith + rating);
	}
}
