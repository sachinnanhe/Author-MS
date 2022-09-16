//package com.author.entity;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//@Entity
//@SequenceGenerator(name="orderseq",initialValue= 10001)
//public class Orders {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orderseq")
//	private Long orderId;
//	
//	
//	private Integer quantity;
//	
//	@JsonFormat(pattern="dd-mm-yyyy")
//	private LocalDate orderDate;
//	
//	private float totalPrice;
//	
//	
//	private Set<Book> orderedBooks = new HashSet<>();
//
//	
//	private Reader readerId;
//
//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public LocalDate getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDate orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public float getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(float totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//
//	public Set<Book> getOrderedBooks() {
//		return orderedBooks;
//	}
//
//	public void setOrderedBooks(Set<Book> orderedBooks) {
//		this.orderedBooks = orderedBooks;
//	}
//
//	public Reader getReader() {
//		return readerId;
//	}
//
//	public void setReader(Reader reader) {
//		this.readerId = reader;
//	}
//
//	
//	
//	
//	
//}
