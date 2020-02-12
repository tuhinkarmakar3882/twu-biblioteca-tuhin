package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviesLibrary {
	private List<Movie> availableMovies;
	private PrintStream outStream;

	public MoviesLibrary(PrintStream outStream) {
		this.availableMovies = initializeWithMovies();
		this.outStream = outStream;
	}

	private ArrayList<Movie> initializeWithMovies() {
		Movie firstMovie = new Movie("Iron Man One", "One Director", 2008, "7");
		Movie secondMovie = new Movie("Avengers One", "Random Person", 2019, "unrated");
		return new ArrayList<>(Arrays.asList(firstMovie, secondMovie));
	}

	public void showMovies() {
		for (Movie movie : availableMovies) {
			movie.printDetails(outStream);
		}
	}
}
