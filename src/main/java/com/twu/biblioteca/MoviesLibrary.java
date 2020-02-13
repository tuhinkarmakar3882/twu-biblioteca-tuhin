package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviesLibrary {
	private List<Movie> availableMoviesList, checkedOutMoviesList;
	private SystemWrapper systemWrapper;

	public MoviesLibrary(SystemWrapper systemWrapper) {
		this.availableMoviesList = initializeWithMovies();
		checkedOutMoviesList = new ArrayList<>();
		this.systemWrapper = systemWrapper;
	}

	public void showMovies() {
		if (hasAvailableMovie()) {
			for (Movie movie : availableMoviesList) {
				movie.printDetails(systemWrapper.getPrintStream());
			}
		}
		Notifications.NO_MOVIES_AVAILABLE.showNotificationOn(systemWrapper.getPrintStream());
	}

	public void checkOutRequest(Movie queriedMovie, SystemWrapper systemWrapper) {

		if (availableMoviesList.contains(queriedMovie)) {

			checkedOutMoviesList.add(queriedMovie);
			availableMoviesList.remove(queriedMovie);

			Notifications.MOVIE_CHECK_OUT_SUCCESS.showNotificationOn(systemWrapper.getPrintStream());
			return;
		}
		Notifications.MOVIE_CHECK_OUT_FAILURE.showNotificationOn(systemWrapper.getPrintStream());
	}

	private ArrayList<Movie> initializeWithMovies() {
		Movie firstMovie = new Movie("Iron Man One", "One Director", 2008, "7");
		Movie secondMovie = new Movie("Avengers One", "Random Person", 2019, "unrated");
		return new ArrayList<>(Arrays.asList(firstMovie, secondMovie));
	}

	private boolean hasAvailableMovie() {
		return availableMoviesList.size() > 0;
	}
}
