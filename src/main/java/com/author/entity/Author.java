package com.author.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Author {

      @Id	
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long authorId;
      
      @NotBlank(message="first name should not be blank")
      private String firstName;
      
      @NotBlank(message="last name should not be blank")
      private String lastName;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Author(Long authorId, @NotBlank(message = "first name should not be blank") String firstName,
			@NotBlank(message = "last name should not be blank") String lastName) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

      
}
