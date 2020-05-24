package designPatterns.dao;

import java.util.Collection;

public interface BookDao {
	Collection<Book> findAllBooks();

	Book findBookByIsbn(Book book);

	void create(Book book);

	void delete(Book book);

	void update(Book book);
}
