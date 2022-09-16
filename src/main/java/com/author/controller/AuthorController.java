package com.author.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.author.entity.Author;
import com.author.entity.Book;
import com.author.entity.Status;
import com.author.repository.AuthorRepository;
import com.author.service.AuthorServiceImpl;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

	@Autowired
	private AuthorServiceImpl authorService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("/register")
	public Status registerAuthor(@Valid @RequestBody Author newAuthor) {
		return this.authorService.createAuthor(newAuthor);
		}

	@PostMapping("/login")
	public Status loginAuthor(@Valid @RequestBody Author newAuthor) {
		return this.authorService.loginAuthor(newAuthor);
		}
	
	@PostMapping("/logout")
    public Status logofAuthor(@Valid @RequestBody Author newAuthor) {
		return this.authorService.logoffAuthor(newAuthor);
	}

//	@PostMapping("/")
//	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
//		return new ResponseEntity<Author>(this.authorService.createAuthor(author), HttpStatus.CREATED);
//	}

	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(this.authorService.createBook(book), HttpStatus.CREATED);
	}

	@PutMapping("book/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book book) {
		return new ResponseEntity<Book>(this.authorService.updateBook(bookId, book), HttpStatus.OK);
	}

	@DeleteMapping("/book/delete")
	public void DeleteAllBooks() {
		this.authorService.deleteAllBooks();
	}

	@DeleteMapping("/book/delete/{authorId}")
	public void deleteAuthorById(@PathVariable Integer authorId) {
		this.authorService.deleteAuthorById(authorId);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer bookId) {
		return new ResponseEntity<Book>(this.authorService.getBookById(bookId), HttpStatus.OK);
	}

	@GetMapping("/allbooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(this.authorService.getAllBooks(), HttpStatus.OK);
	}

	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Book> deleteBookById(@PathVariable("bookId") Integer bookId) {
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			authorService.deleteBookById(bookId);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
