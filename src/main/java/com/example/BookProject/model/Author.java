package com.example.BookProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "author")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long author_id;
	
	private String author_name;
	@Temporal(TemporalType.DATE)
	private Date author_dob;
	
	private String biography;

	@ManyToMany(mappedBy = "authors")
	private List<Book> books;
	
	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Date getAuthor_dob() {
		return author_dob;
	}

	public void setAuthor_dob(Date author_dob) {
		this.author_dob = author_dob;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
}
