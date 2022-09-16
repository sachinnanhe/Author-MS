package com.author.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@SequenceGenerator(name = "bookseq", initialValue = 1001)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookseq")
	
	private Integer bookId;

	@NotBlank(message = "book title should not be blank")
	private String title;

	@NotBlank(message= "author name should not be blank")
	private String authorName;

	@NotBlank(message = "category should not be blank")
	private String category;

	@NotBlank(message = "provide at least one url")
	private String logo;

	private Integer price;

	@NotBlank(message = "publisher should not be blank")
	private String publisher;

	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date publisherDate = new Date();

	private boolean active;
	


	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Book(Integer bookId, @NotBlank(message = "book title should not be blank") String title,
			@NotBlank(message = "author name should not be blank") String authorName,
			@NotBlank(message = "category should not be blank") String category,
			@NotBlank(message = "provide at least one url") String logo, Integer price,
			@NotBlank(message = "publisher should not be blank") String publisher, Date publisherDate, boolean active) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.category = category;
		this.logo = logo;
		this.price = price;
		this.publisher = publisher;
		this.publisherDate = publisherDate;
		this.active = active;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", category=" + category
				+ ", logo=" + logo + ", price=" + price + ", publisher=" + publisher + ", publisherDate="
				+ publisherDate + ", active=" + active + "]";
	}

	
	
}
