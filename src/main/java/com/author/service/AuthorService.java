package com.author.service;

import com.author.entity.Author;
import com.author.entity.Book;

public interface AuthorService {
	
	public Author createAuthor(Author author);
	
	public Book createBook(Book book);
	
	public Book updateBook(Long bookId, Book book);
	
	public void deleteAllBooks();
	
	public Book searchBook(String category, Author author, Integer price, String publisher);

}
