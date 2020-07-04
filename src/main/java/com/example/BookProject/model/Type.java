package com.example.BookProject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "type")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Type {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long type_id;
	
	private String type_name;
	
	@ManyToMany(mappedBy = "types")
	private List<Book> books;

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
