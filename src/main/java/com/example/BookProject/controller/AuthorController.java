package com.example.BookProject.controller;

import java.util.List;

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
import com.example.BookProject.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping
	public List<Author> getAll(){
		return authorRepository.findAll();
	}
	@GetMapping(value = "{author_id}")
	public Author getOne(@PathVariable Long author_id){
		return authorRepository.getOne(author_id);
	}
	
	@PostMapping
	public Author createAuthor(@RequestBody Author author) {
		return authorRepository.saveAndFlush(author);
	}
	
	@RequestMapping(value = "/{author_id}", method = RequestMethod.PUT)
	public Author updateAuthor(@PathVariable Long author_id, @RequestBody Author author) {
		Author existingAuthor = authorRepository.getOne(author_id);
		BeanUtils.copyProperties(author, existingAuthor,"author_id");
		return authorRepository.saveAndFlush(existingAuthor);
	}
	@RequestMapping(value = "{author_id}", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable Long author_id) {
		authorRepository.deleteById(author_id);
	}
	
}
