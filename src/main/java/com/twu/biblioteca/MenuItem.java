package com.twu.biblioteca;

import com.twu.biblioteca.Exceptions.ExitFromApplicationException;

public class MenuItem {
	private String label;
	private Service service;

	public MenuItem(String label, Service service) {
		this.label = label;
		this.service = service;
	}

	public void performAssociatedAction(Library library) throws ExitFromApplicationException {
		service.serveIntent(library);
	}

	public Service getService() {
		return service;
	}

	public String getLabel() {
		return label;
	}
}
