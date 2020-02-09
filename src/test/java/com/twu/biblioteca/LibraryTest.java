package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryTest {
	@Test
	public void testShouldReturnTheLibraryBooks() {
		Book firstBook = new Book("Harry Potter", "J K Rowling", 2012);
		Book secondBook = new Book("Learn Python", "Geeks4Geeks", 2019);
		List<Book> expectedBooks = new ArrayList<>(Arrays.asList(firstBook, secondBook));

		Library library = new Library(new Librarian());

		assertEquals(expectedBooks, library.getBooks());
	}

	@Test
	public void testShouldPrintDetailsOfTheLibraryBooks() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian());

		library.showDetailsOfBooks();

		verify(mockPrintStream, times(1)).println("[+] Listing Down All The Library Books :-");
		verify(mockPrintStream, times(1)).println("Harry Potter\tJ K Rowling\t\t2012");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulCheckOut() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian());
		String bookName = "Harry Potter";
		String authorName = "J K Rowling";
		String publicationYear = "2012";

		InputStream testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.checkOutRequest();

		library.showDetailsOfBooks();
		verify(mockPrintStream, times(1)).println("Thank you! Enjoy the book");
		verify(mockPrintStream, times(0)).println("Harry Potter\tJ K Rowling\t\t2012");
		verify(mockPrintStream, times(1)).println("Learn Python\tGeeks4Geeks\t\t2019");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheBookIsUnavailable() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian());
		String bookName = "Harry Potter";
		String authorName = "J K Rowling";
		String publicationYear = "2012";
		InputStream testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.checkOutRequest();

		testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.checkOutRequest();

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterFailedCheckOutIfTheSpellingIsWrong() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian());


		String bookName = "HOrrI PittAr";
		String authorName = "J K Rowling";
		String publicationYear = "2012";
		InputStream testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.checkOutRequest();

		verify(mockPrintStream, times(1)).println("Sorry, that book is not available");
	}

	@Test
	public void testShouldNotifyAfterSuccessfulReturn() {
		PrintStream mockPrintStream = mock(PrintStream.class);
		System.setOut(mockPrintStream);
		Library library = new Library(new Librarian());
		String bookName = "Harry Potter";
		String authorName = "J K Rowling";
		String publicationYear = "2012";
		InputStream testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.checkOutRequest();

		testInput = new ByteArrayInputStream((bookName + "\n" + authorName + "\n" + publicationYear).getBytes());
		System.setIn(testInput);
		library.returnBookRequest();

		verify(mockPrintStream, times(1)).println("Thank you for returning the book");
	}
}
