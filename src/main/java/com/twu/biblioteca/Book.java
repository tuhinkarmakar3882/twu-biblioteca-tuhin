package com.twu.biblioteca;

import java.util.Objects;

public class Book {
	private final String title;
	private final String author;
	private final int publicationYear;

	public Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public void printDetails() {
		System.out.println(title + "\t" + author + "\t\t" + publicationYear);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return publicationYear == book.publicationYear &&
				title.equals(book.title) &&
				author.equals(book.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, author, publicationYear);
	}
}
