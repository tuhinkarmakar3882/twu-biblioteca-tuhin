package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.UserDoesNotExists;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class CredentialAuthenticatorTest {

	@Test
	void testShouldAllowToLoginValidUser() {
		PrintStream printStream = mock(PrintStream.class);
		ByteArrayInputStream testInput = new ByteArrayInputStream("twu-0001\n1234".getBytes());
		System.setIn(testInput);
		SystemWrapper systemWrapper = new SystemWrapper(testInput, printStream);
		CredentialAuthenticator credentialAuthenticator = new CredentialAuthenticator();
		assertDoesNotThrow(() -> credentialAuthenticator.authenticateUserVia(systemWrapper));
	}

	@Test
	void testShouldNotAllowToLoginInValidUser() {
		PrintStream printStream = mock(PrintStream.class);
		ByteArrayInputStream testInput = new ByteArrayInputStream("twu-0001\n12312345678".getBytes());
		System.setIn(testInput);
		SystemWrapper systemWrapper = new SystemWrapper(testInput, printStream);
		CredentialAuthenticator credentialAuthenticator = new CredentialAuthenticator();
		assertThrows(UserDoesNotExists.class, () -> credentialAuthenticator.authenticateUserVia(systemWrapper));
	}
}