package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

public class MenuItem {
	private String label;
	private Service service;
	private MovieService movieService;

	public MenuItem(String label, Service service) {
		this.label = label;
		this.service = service;
	}

	public MenuItem(String label, MovieService service) {
		this.label = label;
		this.movieService = service;
	}

	public void performAssociatedAction(Library library) throws ExitFromApplicationException {
		service.serveIntent(library);
	}

	public void performAssociatedAction(MoviesLibrary moviesLibrary) {
		movieService.serveIntent(moviesLibrary);
	}

	public String getLabel() {
		return label;
	}
}
