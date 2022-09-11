package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.Author;
import com.author.entity.Book;
import com.author.exception.ResourceNotFoundException;
import com.author.repository.AuthorRepository;
import com.author.repository.BookRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Author createAuthor(Author author) {
		Author saveAuthor = this.authorRepository.save(author);
		return saveAuthor;
	}

	public Book createBook(Book book) {
		Book savedbook = this.bookRepository.save(book);
		return savedbook;
	}

	@Override
	public Book updateBook(Long bookId, Book book) {
		Book book1 = this.bookRepository.findById(bookId).get();
		Book newBook = null;
		if (book1 != null) {
			newBook = this.bookRepository.findById(bookId).get();

			newBook.setTitle(book.getTitle());
			newBook.setAuthor(book.getAuthor());
			newBook.setCategory(book.getCategory());
			newBook.setLogo(book.getLogo());
			newBook.setPrice(book.getPrice());
			newBook.setPublisher(book.getPublisher());
			newBook.setPublisherDate(book.getPublisherDate());
			newBook.setActive(book.isActive());
			return this.bookRepository.save(newBook);
		} else {
			throw new ResourceNotFoundException("Book", "bookId", bookId);
		}
	}

	@Override
	public void deleteAllBooks() {

		this.bookRepository.deleteAll();
	}

	@Override
	public Book searchBook(String category, Author author, Integer price, String publisher) {
		Book book1 = this.bookRepository.getByAuthor(author);
		Book book2 = this.bookRepository.getByCategory(category);
		Book book3 = this.bookRepository.getByPrice(price);
		Book book4 = this.bookRepository.getByPublisher(publisher);
		
		if(book1 != null || book2 != null || book3 != null || book4 != null) {
			Book newBook = book1;
			return newBook;
	}
		else {
			throw new ResourceNotFoundException("Book","book",book1);
		}
            
	}
}
