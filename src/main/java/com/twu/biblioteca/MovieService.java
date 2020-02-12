package com.twu.biblioteca;

public abstract class MovieService {

	public static final MovieService DISPLAY_LIST_OF_MOVIES = new MovieService() {
		@Override
		public void serveIntent(MoviesLibrary moviesLibrary) {
			moviesLibrary.showMovies();
		}
	};

	public abstract void serveIntent(MoviesLibrary moviesLibrary);
}
