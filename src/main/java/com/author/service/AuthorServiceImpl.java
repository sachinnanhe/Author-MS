package com.author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.Author;
import com.author.entity.Book;
import com.author.entity.Status;
import com.author.exception.ResourceNotFoundException;
import com.author.repository.AuthorRepository;
import com.author.repository.BookRepository;
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

//	@Override
//	public Author createAuthor(Author author) {
//		Author saveAuthor = this.authorRepository.save(author);
//		return saveAuthor;
//	}

	public Book createBook(Book book) {
		Book savedbook = this.bookRepository.save(book);
		return savedbook;
	}

	@Override
	public Book updateBook(Integer bookId, Book book) {
		Book book1 = this.bookRepository.findById(bookId).get();
		Book newBook = null;
		if (book1 != null) {
			newBook = this.bookRepository.findById(bookId).get();

			newBook.setTitle(book.getTitle());
			newBook.setAuthorName(book.getAuthorName());
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


//	@Override
//	public void deleteAuthorById(Integer authorId) {
//	   Author author = this.authorRepository.findById(authorId).get();
//	   Author newAuthor = null;
//	   if(author!=null) {
//		   this.authorRepository.deleteById(authorId);
//	   }
//	   else {
//		   throw new ResourceNotFoundException("Author","author",authorId);
//	   }
//		
//	}
	public Book getBookById(Integer bookId) {
		Book book = this.bookRepository.findById(bookId).get();
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return this.bookRepository.findAll();
	}

	@Override
	public void deleteBookById(Integer bookId) {
		
	  this.bookRepository.deleteById(bookId);
		
	}

	@Override
	public List<Book> searchBook(String query) {
		List<Book> book = this.bookRepository.searchBook(query);
		return book;
	}

	@Override
	public Status createAuthor(Author newAuthor) {
		
		List<Author> authors = authorRepository.findAll();
		System.out.println("New user: " + newAuthor.toString());
		for (Author author : authors) {
			System.out.println("Registered author: " + newAuthor.toString());
			if (author.equals(newAuthor)) {
				System.out.println("User Already exists!");
				return Status.AUTHOR_ALREADY_EXISTS;
			}
		}
		authorRepository.save(newAuthor);
		return Status.SUCCESS;
	}

	@Override
	public void deleteAuthorById(Integer authorId) {
		this.authorRepository.deleteById(authorId);
		
	}

	@Override
	public Status loginAuthor(Author author) {
		
		List<Author> authors = authorRepository.findAll();
		for (Author other : authors) {
			if (other.equals(author)) {
//				String query=author.getAuthorName();
//				authorRepository.deleteAuthorByName(author.getAuthorName());
				
				author.setLoggedIn(true);
				authorRepository.save(author);
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	@Override
	public Status logoffAuthor(Author author) {
		 List<Author> authors = authorRepository.findAll();
	        for (Author other : authors) {
	            if (other.equals(author)) {
	                author.setLoggedIn(false);
	                authorRepository.save(author);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	}



	
		
	}
