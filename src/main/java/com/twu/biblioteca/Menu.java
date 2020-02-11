package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<String> menuList = new ArrayList<>();

	public Menu() {
		initializeWithDefaultEntries();
	}

	private void initializeWithDefaultEntries() {
		menuList.add("Exit the Application");
		menuList.add("List of book");
		menuList.add("Check-out a Book");
		menuList.add("Return a Book");
	}

	public void showOptions() {
		for (int itemNumber = 0; itemNumber < menuList.size(); itemNumber++) {
			System.out.println(itemNumber + " : " + menuList.get(itemNumber));
		}
	}

	public boolean isValidOption(String option) {
		try {
			int newOption = Integer.parseInt(option);
			return newOption >= 0 && newOption < menuList.size();
		} catch (NumberFormatException exception) {
			return false;
		}
	}
}
