//package com.author.entity;
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//@Entity
//@SequenceGenerator(name = "readerseq", initialValue = 101)
//public class Reader {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "readerseq")
//	private Long readerId;
//
//	@NotBlank(message = "name should not be blank")
//	private String name;
//
//	@NotBlank(message = "email should not be blank")
//	@Email(message="enter valid email address")
//	private String email;
//	
//	@NotBlank
//	@Size(min=5, max=10, message="must contain atleast one special character")
//	private String password;
//	
//	
//	private List<Orders> orderList= new ArrayList<>();
//
//
//	public Long getReaderId() {
//		return readerId;
//	}
//
//	public void setReaderId(Long readerId) {
//		this.readerId = readerId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Reader(Long readerId, @NotBlank(message = "name should not be blank") String name,
//			@NotBlank(message = "email should not be blank") String email) {
//		super();
//		this.readerId = readerId;
//		this.name = name;
//		this.email = email;
//	}
//
//	public Reader() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//}
