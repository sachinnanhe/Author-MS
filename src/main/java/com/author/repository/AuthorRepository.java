package com.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.author.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{ 
	
//	@Query("SELECT p FROM Book p WHERE " +
//			  "p.authorName LIKE CONCAT('%',:query,'%')")
//	public void deleteAuthorByName(String query);
	
//	void deleteAuthorByName(String authorName);

}
