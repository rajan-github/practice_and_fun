package designPatterns.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Book {
	private static Map<String, Book> bookstore = new HashMap<>();
	private String isbn;
	private String title;
	private String author;

	public Collection<Book> findAllBooks() {
		return bookstore.values();
	}

	public Book findBookByIsbn(String isbn) {
		return bookstore.get(isbn);
	}

	public void create() {
		bookstore.put(isbn, this);
	}

	public void delete() {
		bookstore.remove(isbn);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
