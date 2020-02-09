package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Library {
	private final List<Book> bookList;
	private Librarian librarian;

	public Library(Librarian librarian) {
		this.librarian = librarian;
		this.bookList = initializeWithBooks();
	}

	public List<Book> getBooks() {
		return bookList;
	}

	public void showDetailsOfBooks() {
		System.out.println("[+] Listing Down All The Library Books :-");
		System.out.println("Book Name" + "\t\t" + "Author Name" + "\t\t" + "Publication Year");
		for (Book book : bookList) {
			if (librarian.hasAvailableForCheckOut(book)) {
				book.printDetails();
			}
		}
	}

	public void checkOutRequest() {
		Book queriedBook = getUserQueriedBook();
		if (librarian.hasAvailableForCheckOut(queriedBook) && bookList.contains(queriedBook)) {
			librarian.checkOutBook(queriedBook);
			System.out.println("Thank you! Enjoy the book");
			return;
		}
		System.out.println("Sorry, that book is not available");
	}

	public void returnBookRequest() {
		Book bookToBeReturned = getUserQueriedBook();
		if (!librarian.hasAvailableForCheckOut(bookToBeReturned)) {
			librarian.returnBook(bookToBeReturned);
			System.out.println("Thank you for returning the book");
			return;
		}
		System.out.println("That is not a valid book to return.");
	}

	private List<Book> initializeWithBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		Book secondBook = new Book("Learn Python", "Geeks4Geeks", 2019);
		return Arrays.asList(firstBook, secondBook);
	}

	private Book getUserQueriedBook() {
		System.out.println("[+] Book Check out Request");
		Scanner scanner = new Scanner(System.in);

		System.out.println("\t[+] Book Name : ");
		String bookName = scanner.nextLine();
		System.out.println("\t[+] Author Name : ");
		String authorName = scanner.nextLine();
		System.out.println("\t[+] Publication Year : ");
		int publicationYear = scanner.nextInt();

		return new Book(bookName, authorName, publicationYear);
	}

}
