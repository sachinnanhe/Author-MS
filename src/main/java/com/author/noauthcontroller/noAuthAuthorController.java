package com.author.noauthcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.author.entity.Book;
import com.author.service.AuthorService;

@RestController
@RequestMapping("/noauth/author")
public class noAuthAuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/book/search")
	public List<Book> searchBook(@RequestParam("query") String query){
		return this.authorService.searchBook(query);
	}

}
