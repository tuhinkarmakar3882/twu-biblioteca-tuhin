package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class CredentialAuthenticationTest {

	@Test
	void testShouldAllowToLoginValidUser() {
		PrintStream printStream = mock(PrintStream.class);
		ByteArrayInputStream testInput = new ByteArrayInputStream("twu-0001\n1234".getBytes());
		System.setIn(testInput);
		SystemWrapper systemWrapper = new SystemWrapper(testInput, printStream);
		assertDoesNotThrow(() -> CredentialAuthentication.authenticateUserVia(systemWrapper));
	}

	@Test
	void testShouldNotAllowToLoginInValidUser() {
		PrintStream printStream = mock(PrintStream.class);
		ByteArrayInputStream testInput = new ByteArrayInputStream("twu-0001\n12312345678".getBytes());
		System.setIn(testInput);
		SystemWrapper systemWrapper = new SystemWrapper(testInput, printStream);
		assertThrows(UserDoesNotExists.class, () -> CredentialAuthentication.authenticateUserVia(systemWrapper));
	}
}