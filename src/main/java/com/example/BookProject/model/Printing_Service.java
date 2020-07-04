package com.example.BookProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "printing_service")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Printing_Service {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long printing_service_id;
	private String printing_service_name;
	private String printing_service_address;
	private String phone_no;
	private String email;
	
	
	@OneToMany(mappedBy = "printingService",
			 fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("printingService")
	private List<Book> books;
	
	
	
	
	public Long getPrinting_service_id() {
		return printing_service_id;
	}
	public void setPrinting_service_id(Long printing_service_id) {
		this.printing_service_id = printing_service_id;
	}
	public String getPrinting_service_name() {
		return printing_service_name;
	}
	public void setPrinting_service_name(String printing_service_name) {
		this.printing_service_name = printing_service_name;
	}
	public String getPrinting_service_address() {
		return printing_service_address;
	}
	public void setPrinting_service_address(String printing_service_address) {
		this.printing_service_address = printing_service_address;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
