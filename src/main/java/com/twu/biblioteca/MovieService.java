package com.twu.biblioteca;

public abstract class MovieService {

	public static final MovieService DISPLAY_LIST_OF_MOVIES = new MovieService() {
		@Override
		public void serveIntent(MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
			moviesLibrary.showMovies();
		}
	};
	public static final MovieService RAISE_A_CHECKOUT_REQUEST = new MovieService() {
		@Override
		public void serveIntent(MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
			Movie queriedMovie = getUserQueriedMovie(systemWrapper);
			moviesLibrary.checkOutRequest(queriedMovie, systemWrapper);
		}
	};

	public abstract void serveIntent(MoviesLibrary moviesLibrary, SystemWrapper systemWrapper);

	private static Movie getUserQueriedMovie(SystemWrapper systemWrapper) {
		System.out.println("[+] Movie Check out Request");

		System.out.println("\t[+] Movie Name : ");
		String movieName = systemWrapper.takeInput();
		System.out.println("\t[+] Director Name : ");
		String directorName = systemWrapper.takeInput();
		System.out.println("\t[+] Releasing Year : ");
		int releasingYear = Integer.parseInt(systemWrapper.takeInput());
		System.out.println("\t[+] Rating : ");
		String movieRating = systemWrapper.takeInput();

		return new Movie(movieName, directorName, releasingYear, movieRating);

	}

}
