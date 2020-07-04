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
import com.example.BookProject.model.Type;
import com.example.BookProject.repository.TypeRepository;

@RestController
@RequestMapping("/type")
public class TypeController {

	
	@Autowired
	private TypeRepository typeRepository;
	
	
	@GetMapping
	public List<Type> getAll(){
		return typeRepository.findAll();
	}
	
	@GetMapping(value = "{type_id}")
	public Type getOne(@PathVariable Long type_id){
		return typeRepository.getOne(type_id);
	}
	
	@PostMapping
	public Type createType(@RequestBody Type type) {
		return typeRepository.saveAndFlush(type);
	}
	
	@RequestMapping(value = "/{type_id}", method = RequestMethod.PUT)
	public Type updateType(@PathVariable Long type_id, @RequestBody Type type) {
		Type existingType = typeRepository.getOne(type_id);
		BeanUtils.copyProperties(type, existingType, "type_id");
		return typeRepository.saveAndFlush(existingType);
	}
	@RequestMapping(value = "{type_id}", method = RequestMethod.DELETE)
	public void deleteType(@PathVariable Long type_id) {
		typeRepository.deleteById(type_id);
	}
}
