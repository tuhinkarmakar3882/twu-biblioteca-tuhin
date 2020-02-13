package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class UserTest {

	@Test
	void testShouldPrintTheUserDetailsOnSystemWrapperOutStream() {
		User user = new User("1234-4567", "1234", "User One", "user@example.com", "+919876543210");
		PrintStream mockedPrintStream = mock(PrintStream.class);
		SystemWrapper systemWrapper = new SystemWrapper(System.in, mockedPrintStream);

		user.showDetails(systemWrapper);


		verify(mockedPrintStream, times(1)).println("Name : User One");
		verify(mockedPrintStream, times(1)).println("Email : user@example.com");
		verify(mockedPrintStream, times(1)).println("Phone Number : +919876543210");

	}
}