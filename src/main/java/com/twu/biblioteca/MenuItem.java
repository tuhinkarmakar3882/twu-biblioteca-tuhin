package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;
import com.twu.biblioteca.Exceptions.UserDoesNotExists;

public class MenuItem {
	private String label;
	private Service service;
	private MovieService movieService;
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

	public void performAssociatedAction(Library library, SystemWrapper systemWrapper) throws ExitFromApplicationException, UserDoesNotExists {
		service.serveIntent(library, systemWrapper);
	}

	public void performAssociatedAction(MoviesLibrary moviesLibrary, SystemWrapper systemWrapper) {
		movieService.serveIntent(moviesLibrary, systemWrapper);
	}

	public String getLabel() {
		return label;
	}

	public String getTypeOfService() {
		return typeOfService;
	}
}
