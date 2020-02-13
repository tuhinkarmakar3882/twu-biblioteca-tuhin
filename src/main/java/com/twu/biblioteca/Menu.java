package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

	private List<MenuItem> menuList = new ArrayList<>();
	private PrintStream outStream;
	private HashMap<Integer, MenuItem> menuItemCommandMap;
	private boolean systemControllerIsReady;

	public Menu(PrintStream outStream) {
		menuItemCommandMap = new HashMap<>();
		this.outStream = outStream;
		systemControllerIsReady = false;
		addDefaultEntries();
	}

	public void showOptions() {
		if (systemControllerIsReady) { //	To Avoid Null Pointer Exception in the First Run
			modifyMenuItemsBasedOnLogInStatus(); // Add User Options, if the user is Logged in
		}

		createMapOfActions();

		for (int itemNumber = 0; itemNumber < menuList.size(); itemNumber++) { // Print out the menu items
			outStream.println(itemNumber + " : " + menuList.get(itemNumber).getLabel());
		}

		systemControllerIsReady = true;
	}

	public boolean isValidOption(String option) {
		int newOption = Integer.parseInt(option);
		return newOption >= 0 && newOption < menuList.size();
	}

	public MenuItem getMenuItem(String option) {
		return menuItemCommandMap.get(Integer.parseInt(option));
	}

	private void addDefaultEntries() {
		menuList.add(new MenuItem("Exit the Application", Service.EXIT_SYSTEM));
		menuList.add(new MenuItem("List of book", Service.DISPLAY_BOOKS));
		menuList.add(new MenuItem("Check-out a Book", Service.RAISE_A_CHECKOUT_REQUEST));
		menuList.add(new MenuItem("Return a Book", Service.RAISE_A_RETURN_REQUEST));
		menuList.add(new MenuItem("List of All Movies", MovieService.DISPLAY_LIST_OF_MOVIES));
		menuList.add(new MenuItem("Check out a Movie", MovieService.RAISE_A_CHECKOUT_REQUEST));
	}

	private void modifyMenuItemsBasedOnLogInStatus() {
		MenuItem userOption = new MenuItem("Show Details", UserService.SHOW_DETAILS);

		if (SystemController.credentialAuthenticator.getAuthStatus()) { //if user is logged in
			if (!menuList.contains(userOption)) {        // And menu does not already has the user options
				menuList.add(userOption);
			}
		} else {
			//At this point user is not logged in
			menuList.remove(userOption);            // // If, however, menu has the user options, remove it
		}
	}

	private void createMapOfActions() {
		for (int itemNumber = 0; itemNumber < menuList.size(); itemNumber++) {
			menuItemCommandMap.put(itemNumber, menuList.get(itemNumber));
		}
	}
}