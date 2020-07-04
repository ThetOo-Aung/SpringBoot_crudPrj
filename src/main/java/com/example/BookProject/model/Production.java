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

@Entity(name = "production")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Production {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long production_id;
	private String production_name;
	private String production_address;
	private String phone_no;
	private String email;
	
	@OneToMany(mappedBy = "production",  fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("production")
	private List<Book> books;
	
	public Long getProduction_id() {
		return production_id;
	}
	public void setProduction_id(Long production_id) {
		this.production_id = production_id;
	}
	public String getProduction_name() {
		return production_name;
	}
	public void setProduction_name(String production_name) {
		this.production_name = production_name;
	}
	public String getProduction_address() {
		return production_address;
	}
	public void setProduction_address(String production_address) {
		this.production_address = production_address;
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
