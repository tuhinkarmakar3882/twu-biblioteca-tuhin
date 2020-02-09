package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class MenuTest {
	PrintStream mockPrintStream;

	@BeforeEach
	public void setup() {
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
	}

	@Test
	public void testShouldCreateAMenuAndDisplayItsOptions1() {
		Menu menu = new Menu();
		String expectedMenuOptions = "1 : List of book";

		menu.showOptions();

		verify(mockPrintStream, times(1)).println(expectedMenuOptions);
	}

	@Test
	public void testShouldCreateAMenuAndDisplayItsOptions() {
		Menu menu = new Menu();
		List<String> expectedMenuOptions = new ArrayList<>(Arrays.asList("1 : List of book", "2 : Check-out a Book", "3 : Exit the Application"));

		menu.showOptions();

		verify(mockPrintStream, times(1)).println(expectedMenuOptions.get(0));
		verify(mockPrintStream, times(1)).println(expectedMenuOptions.get(1));
		verify(mockPrintStream, times(1)).println(expectedMenuOptions.get(2));
	}
}
