package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return year == movie.year &&
				name.equals(movie.name) &&
				directorName.equals(movie.directorName) &&
				rating.equals(movie.rating);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, directorName, rating, year);
	}
}
