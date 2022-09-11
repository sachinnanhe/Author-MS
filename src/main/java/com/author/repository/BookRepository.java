package com.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.author.entity.Author;
import com.author.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	public Book getByCategory(String category);
	public Book getByAuthor(Author author);
	public Book getByPrice(Integer price);
	public Book getByPublisher(String publisher);

}
