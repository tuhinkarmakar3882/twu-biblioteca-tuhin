package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.UserDoesNotExists;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class CredentialAuthenticator {

	private User authenticatedUser = null;
	private boolean logInStatus = false;

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


		User user = getUserCredentials(systemWrapper);

		if (USER_DATABASE.contains(user)) {
			Notifications.LOGIN_SUCCESSFUL.showNotificationOn(systemWrapper.getPrintStream());

			authenticatedUser = loadMatchingUserDetails(user);

			return authenticatedUser;
		}

		throw new UserDoesNotExists();
	}

	public boolean getAuthStatus() {
		return logInStatus;
	}

	private User loadMatchingUserDetails(User user) {
		for (User userInDatabase : USER_DATABASE) {
			if (userInDatabase.equals(user)) {
				logInStatus = true;
				return userInDatabase;
			}
		}
		return null;
	}

	private User getUserCredentials(SystemWrapper systemWrapper) {
		systemWrapper.getPrintStream().println("Library Number : ");
		String libraryNumber = systemWrapper.takeInput();

		systemWrapper.getPrintStream().println("Password : ");
		String password = systemWrapper.takeInput();
		return new User(libraryNumber, password, null, null, null);
	}
}
