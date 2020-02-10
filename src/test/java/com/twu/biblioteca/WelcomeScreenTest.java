package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class WelcomeScreenTest {

	PrintStream mockPrintStream;

	@BeforeEach
	public void setup() {
		mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
	}

	@Test
	public void testShouldPrintHelloWorldToConsole() {
		WelcomeScreen welcomeScreen = new WelcomeScreen("hello", System.out);

		welcomeScreen.showMessage();

		verify(mockPrintStream, times(1)).println("hello");
	}

	@Test
	public void testShouldPrintTheGivenMessageToConsole() {
		String givenWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
		WelcomeScreen welcomeScreen = new WelcomeScreen(givenWelcomeMessage, System.out);

		welcomeScreen.showMessage();

		verify(mockPrintStream, times(1)).println(givenWelcomeMessage);
	}
}