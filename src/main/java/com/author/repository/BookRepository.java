package com.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.author.entity.Author;
import com.author.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("SELECT p FROM Book p WHERE " +
	  "p.category LIKE CONCAT('%',:query,'%')"+
			"Or p.authorName LIKE CONCAT('%',:query,'%')"+
	        "Or p.price LIKE CONCAT('%',:query,'%')")
		List<Book> searchBook(String query);	
			

}
