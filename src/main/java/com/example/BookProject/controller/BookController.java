package com.example.BookProject.controller;

import java.util.List;

import javax.print.PrintService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookProject.model.Author;
import com.example.BookProject.model.Book;
import com.example.BookProject.model.Printing_Service;
import com.example.BookProject.model.Production;
import com.example.BookProject.model.Type;
import com.example.BookProject.repository.AuthorRepository;
import com.example.BookProject.repository.BookRepository;
import com.example.BookProject.repository.PrintingServiceRepository;
import com.example.BookProject.repository.ProductionRepositroy;
import com.example.BookProject.repository.TypeRepository;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PrintingServiceRepository printingServiceRepository;
	
	@Autowired
	private ProductionRepositroy productionRepositroy;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@GetMapping
	public List<Book> getAll(){
		return bookRepository.findAll();
	}
	
	@GetMapping(value = "{book_id}")
	public Book getById(@PathVariable Long book_id) {
		return bookRepository.getOne(book_id);
	}
	
	@PostMapping(value = "/add/{printing_service_id}/{production_id}")
	public Book createBook(@PathVariable Long printing_service_id,@PathVariable Long production_id,
			@RequestBody Book book) {
		
		Printing_Service ps = printingServiceRepository.getOne(printing_service_id);
		Production production = productionRepositroy.getOne(production_id);
		book.setPrintingService(ps);
		book.setProduction(production);
		return bookRepository.saveAndFlush(book);
	}
	
	@RequestMapping(value = "{book_id}/update/{printing_service_id}/{production_id}", method = RequestMethod.PUT)
	public Book updateBook(@PathVariable Long book_id,@PathVariable Long printing_service_id,@PathVariable Long production_id, @RequestBody Book book) {
		Printing_Service ps = printingServiceRepository.getOne(printing_service_id);
		Production production = productionRepositroy.getOne(production_id);
		book.setPrintingService(ps);
		book.setProduction(production);
		Book existingBook = bookRepository.getOne(book_id);
		BeanUtils.copyProperties(book, existingBook, "book_id");
		return bookRepository.saveAndFlush(existingBook);
	}
	
	@RequestMapping(value = "{book_id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable Long book_id) {
		bookRepository.deleteById(book_id);
	}
	
	
	@RequestMapping(value = "{book_id}/add/author/{author_id}", method = RequestMethod.PUT)
	public Book addAuthor(@PathVariable Long book_id, @PathVariable Long author_id){
		Book book = bookRepository.getOne(book_id);
		Author author = authorRepository.getOne(author_id);
		book.getAuthors().add(author);
		return bookRepository.saveAndFlush(book);
	}
	
	@RequestMapping(value = "{book_id}/remove/author/{author_id}", method = RequestMethod.DELETE)
	public Book deleteAuthor(@PathVariable Long book_id, @PathVariable Long author_id){
		Book book = bookRepository.getOne(book_id);
		Author author = authorRepository.getOne(author_id);
		book.getAuthors().remove(author);
		return bookRepository.saveAndFlush(book);
	}
	
	
	@RequestMapping(value="{book_id}/add/type/{type_id}", method = RequestMethod.PUT )
	public Book addType(@PathVariable Long type_id, @PathVariable Long book_id) {
		Book book = bookRepository.getOne(book_id);
		Type type = typeRepository.getOne(type_id);
		book.getTypes().add(type);
		return bookRepository.saveAndFlush(book);
	}
	
	@RequestMapping(value="{book_id}/remove/type/{type_id}", method = RequestMethod.DELETE )
	public Book deleteType (@PathVariable Long type_id , @PathVariable Long book_id) {
		Book book = bookRepository.getOne(book_id);
		Type type = typeRepository.getOne(type_id);
		book.getTypes().remove(type);
		return bookRepository.saveAndFlush(book);
	}

	
	
}

