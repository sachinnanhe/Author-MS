package com.author.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorId;

	@NotBlank(message = "first name should not be blank")
	private String authorName;

	@NotBlank
	@Email(message = "enter valid email address")
	private String emailId;

	@NotBlank(message = "password should not be blank")
	@Size(min = 5, max = 10, message = "must contain one special character")
	private String password;

	private boolean loggedIn;

	public Integer getAuthorId() {
		return authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	

	
	public Author(@NotBlank @Email(message = "enter valid email address") String emailId,
			@NotBlank(message = "password should not be blank") @Size(min = 5, max = 10, message = "must contain one special character") String password,
			boolean loggedIn) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.loggedIn = false;
	}

	public Author(@NotBlank(message = "first name should not be blank") String authorName,
			@NotBlank @Email(message = "enter valid email address") String emailId,
			@NotBlank(message = "password should not be blank") @Size(min = 5, max = 10, message = "must contain one special character") String password) {
		super();
		this.authorName = authorName;
		this.emailId = emailId;
		this.password = password;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Author))
			return false;
		Author author = (Author) o;
		return Objects.equals(authorName, author.authorName) && Objects.equals(emailId, author.emailId)
				&& Objects.equals(password, author.password);
	}

	public int hashCode() {
		return Objects.hash( authorName, emailId, password, loggedIn);
	}

	@Override
	public String toString() {
		return "Author [ authorName=" + authorName + ", emailId=" + emailId + ", password="
				+ password + ", loggedIn=" + loggedIn + "]";
	}

}
