package com.twu.biblioteca;

import java.util.HashSet;

public class Menu {

	HashSet<String> menuList = new HashSet<>();

	public Menu() {
		initializeWithDefaultEntries();
	}

	private void initializeWithDefaultEntries() {
		menuList.add("List of book");
	}

	public void showOptions() {
		System.out.println("Menu : ");
		for (String menuItem : menuList) {
			System.out.println(menuItem);
		}
	}
}
