package com.example.BookProject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "book")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long book_id;
	
	private String book_name;
	private byte edition;
	
	
	@ManyToMany
	@JoinTable(name = "book_author",
				joinColumns = @JoinColumn(name = "book_id"),
				inverseJoinColumns = @JoinColumn(name = "author_id")
			)
	@JsonIgnoreProperties("books")
	private List<Author> authors;
	
	@ManyToMany
	@JoinTable(name = "book_type",
				joinColumns = @JoinColumn(name = "book_id"),
				inverseJoinColumns = @JoinColumn(name = "type_id")
			)
	@JsonIgnoreProperties("books")
	private List<Type> types;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "printing_service_id", nullable = false)
	@JsonIgnoreProperties("books")
	private Printing_Service printingService;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "production_id", nullable = false)
	@JsonIgnoreProperties("books")
	private Production production;
	
	
	public Book() {
		
	}
	
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public byte getEdition() {
		return edition;
	}
	public void setEdition(byte edition) {
		this.edition = edition;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Printing_Service getPrintingService() {
		return printingService;
	}

	public void setPrintingService(Printing_Service printingService) {
		this.printingService = printingService;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	
	
	
}
