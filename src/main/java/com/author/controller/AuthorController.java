package com.author.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.author.entity.Author;
import com.author.entity.Book;
import com.author.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author){
		return new ResponseEntity<Author>(this.authorService.createAuthor(author),HttpStatus.CREATED);
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return new ResponseEntity<Book>(this.authorService.createBook(book),HttpStatus.CREATED);
	}
	
	@PutMapping("book/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book){
		return new ResponseEntity<Book>(this.authorService.updateBook(bookId, book),HttpStatus.OK);
	}
	
	@DeleteMapping("/book/delete")
	public void DeleteAllBooks(){
		this.authorService.deleteAllBooks();
	}
	@GetMapping("/book/search")
	public ResponseEntity<Book> searchBook(@RequestParam String category, @RequestParam Author author, @RequestParam Integer price, @RequestParam String publisher) {
		return new ResponseEntity<Book>(this.authorService.searchBook(category, author, price, publisher),HttpStatus.ACCEPTED);
	}

}
