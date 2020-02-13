package com.twu.biblioteca;

public abstract class UserService {

	public static final UserService SHOW_DETAILS = new UserService() {
		@Override
		public void serveIntent(User user, SystemWrapper systemWrapper) {
			user.showDetails(systemWrapper);
		}
	};

	public abstract void serveIntent(User user, SystemWrapper systemWrapper);

}
