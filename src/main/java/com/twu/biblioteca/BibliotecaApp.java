package com.twu.biblioteca;

public class BibliotecaApp {

	public static void main(String[] args) {
		WelcomeScreen welcomeScreen = new WelcomeScreen("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
		welcomeScreen.showMessage();

		Library library = new Library();
		library.showBookDetails();
	}
}
