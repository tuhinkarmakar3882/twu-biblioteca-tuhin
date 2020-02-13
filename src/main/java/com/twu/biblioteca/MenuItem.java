package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.UserDoesNotExists;

import java.util.Objects;

public class MenuItem {
	private String label;
	private Service service;
	private MovieService movieService;
	private UserService userService;
	private String typeOfService;


	public MenuItem(String label, Service service) {
		this.label = label;
		this.service = service;
		this.typeOfService = "LIBRARY";
	}

	public MenuItem(String label, MovieService service) {
		this.label = label;
		this.movieService = service;
		this.typeOfService = "MOVIES";
	}

	public MenuItem(String label, UserService service) {
		this.label = label;
		this.userService = service;
		this.typeOfService = "USER";
	}

	public void performAssociatedAction(Library library, SystemWrapper systemWrapper) throws ExitFromApplicationException, UserDoesNotExists {
		service.serveIntent(library, systemWrapper);
	}

	public void performAssociatedAction(MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
		movieService.serveIntent(moviesLibrary, systemWrapper);
	}

	public void performAssociatedAction(User user, SystemWrapper systemWrapper) {
		userService.serveIntent(user, systemWrapper);
	}

	public String getLabel() {
		return label;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MenuItem menuItem = (MenuItem) o;
		return label.equals(menuItem.label) &&
				typeOfService.equals(menuItem.typeOfService);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label, service, movieService, userService, typeOfService);
	}
}
