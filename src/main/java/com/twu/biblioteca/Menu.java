package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

	private List<MenuItem> menuList = new ArrayList<>();
	private PrintStream outStream;
	private HashMap<Integer, MenuItem> menuItemCommandMap;

	public Menu(PrintStream outStream) {
		menuItemCommandMap = new HashMap<>();
		this.outStream = outStream;
		addDefaultEntries();
		createMapOfActions();
	}

	public void showOptions() {

		for (int itemNumber = 0; itemNumber < menuList.size(); itemNumber++) {
			outStream.println(itemNumber + " : " + menuList.get(itemNumber).getLabel());
		}
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
	}

	private void createMapOfActions() {
		for (int itemNumber = 0; itemNumber < menuList.size(); itemNumber++) {
			menuItemCommandMap.put(itemNumber, menuList.get(itemNumber));
		}
	}
}