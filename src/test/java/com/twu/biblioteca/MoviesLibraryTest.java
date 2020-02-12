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
		MoviesLibrary moviesLibrary = new MoviesLibrary(mockPrintStream);


		moviesLibrary.showMovies();


		verify(mockPrintStream, times(1)).println("Iron Man One | One Director | 2008 | 7");
		verify(mockPrintStream, times(1)).println("Avengers One | Random Person | 2019 | unrated");
	}
}