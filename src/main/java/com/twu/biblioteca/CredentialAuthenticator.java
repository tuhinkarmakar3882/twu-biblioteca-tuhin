package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.UserDoesNotExists;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class CredentialAuthenticator {

	private User authenticatedUser = null;

	public CredentialAuthenticator() {
	}

	private static ArrayList<User> USER_DATABASE = new ArrayList<>(asList(
			new User("twu-0001", "1234", "User One", "abc@gmail.com", "1234567890"),
			new User("twu-0002", "0000", "User Two", "efg@gmail.com", "0987654321"),
			new User("twu-0003", "4321", "User Three", "qwerty@werty.com", "1234567876")
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

		User user = new User(libraryNumber, password, null, null, null);

		if (USER_DATABASE.contains(user)) {
			systemWrapper.getPrintStream().println("Login Successful!");
			for (User userInDatabase : USER_DATABASE) {
				if (userInDatabase.equals(user)) {
					authenticatedUser = userInDatabase;
				}
			}
			return authenticatedUser;
		}
		throw new UserDoesNotExists();
	}
}
