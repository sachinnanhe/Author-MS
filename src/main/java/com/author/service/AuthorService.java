package com.author.service;

import java.util.List;

import com.author.entity.Author;
import com.author.entity.Book;
import com.author.entity.Status;


public interface AuthorService {
	
	public Status createAuthor(Author newauthor);
	
	public Status loginAuthor(Author author);
	
	public Status logoffAuthor(Author author);
	
	public Book createBook(Book book);
	
	public Book updateBook(Integer bookId, Book book);
	
	public void deleteAllBooks();
	
	public Book getBookById(Integer bookId);
	
	public void deleteAuthorById(Integer authorId);
	
	public List<Book> getAllBooks();
	
	public void deleteBookById(Integer bookId);
	
    public List<Book> searchBook(String query);
    
    

}
