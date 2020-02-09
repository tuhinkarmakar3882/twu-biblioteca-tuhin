package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<String> menuList = new ArrayList<>();

	public Menu() {
		initializeWithDefaultEntries();
	}

	private void initializeWithDefaultEntries() {
		menuList.add("List of book");
		menuList.add("Exit the Application");
	}

	public void showOptions() {
		for (int itemNumber = 1; itemNumber <= menuList.size(); itemNumber++) {
			System.out.println(itemNumber + " : " + menuList.get(itemNumber - 1));
		}
	}
}
