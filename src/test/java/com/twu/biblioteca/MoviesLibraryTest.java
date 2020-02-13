package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class MoviesLibraryTest {
	PrintStream mockPrintStream;

	@BeforeEach
	void setup() {
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);

	}

	@Test
	void testShouldReturnAListOfAllMovies() {
		MoviesLibrary moviesLibrary = new MoviesLibrary(new SystemWrapper(System.in, mockPrintStream));

		moviesLibrary.showMovies();

		verify(mockPrintStream, times(1)).println("Iron Man One | One Director | 2008 | 7");
		verify(mockPrintStream, times(1)).println("Avengers One | Random Person | 2019 | unrated");
	}


	@Test
	void testShouldAllowCheckOutAnAvailableMovie() {
		SystemWrapper systemWrapper = new SystemWrapper(System.in, mockPrintStream);
		MoviesLibrary moviesLibrary = new MoviesLibrary(systemWrapper);

		Movie movie = new Movie("Iron Man One", "One Director", 2008, "7");

		moviesLibrary.checkOutRequest(movie, systemWrapper);
		moviesLibrary.showMovies();

		verify(mockPrintStream, times(0)).println("Iron Man One | One Director | 2008 | 7");
		verify(mockPrintStream, times(1)).println("Avengers One | Random Person | 2019 | unrated");
	}

	@Test
	void testShouldNotAllowToCheckOutAnUnavailableMovie() {
		SystemWrapper systemWrapper = new SystemWrapper(System.in, mockPrintStream);
		MoviesLibrary moviesLibrary = new MoviesLibrary(systemWrapper);

		Movie movie = new Movie("Random Movie", "Unknown Director", 2028, "10");

		moviesLibrary.checkOutRequest(movie, systemWrapper);
		moviesLibrary.showMovies();

		verify(mockPrintStream, times(1)).println("Sorry, that movie is not available");
		verify(mockPrintStream, times(1)).println("Iron Man One | One Director | 2008 | 7");
		verify(mockPrintStream, times(1)).println("Avengers One | Random Person | 2019 | unrated");
	}


}