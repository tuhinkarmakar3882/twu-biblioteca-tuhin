package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.UserDoesNotExists;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class CredentialAuthenticator {

	private User authenticatedUser = null;

	public CredentialAuthenticator() {
	}

	private static HashSet<User> USER_DATABASE = new HashSet<>(asList(
			new User("twu-0001", "1234"),
			new User("twu-0002", "0000"),
			new User("twu-0003", "4321")
	));

	public User authenticateUserVia(SystemWrapper systemWrapper) throws UserDoesNotExists {

		if (this.authenticatedUser != null) {
			systemWrapper.getPrintStream().println("Logged in as : " + authenticatedUser);
			return authenticatedUser;
		}

		systemWrapper.getPrintStream().println("Library Number : ");
		String libraryNumber = systemWrapper.takeInput();

		systemWrapper.getPrintStream().println("Password : ");
		String password = systemWrapper.takeInput();

		User user = new User(libraryNumber, password);

		if (USER_DATABASE.contains(user)) {
			systemWrapper.getPrintStream().println("Login Successful!");
			authenticatedUser = user;
			return authenticatedUser;
		}
		throw new UserDoesNotExists();
	}
}
