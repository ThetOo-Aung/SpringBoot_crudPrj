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
import com.example.BookProject.model.Production;
import com.example.BookProject.repository.ProductionRepositroy;

@RestController
@RequestMapping("/production")
public class ProductionController {
	
	@Autowired
	private ProductionRepositroy productionRepositroy;
	
	@GetMapping
	public List<Production> getAll() {
		return productionRepositroy.findAll();
	}
	
	@GetMapping("{id}")
	public Production getOne(@PathVariable Long id) {
		return productionRepositroy.getOne(id);
	}
	
	
	@PostMapping
	public Production createProduction(@RequestBody Production production) {
		return productionRepositroy.saveAndFlush(production);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Production updateProduction(@PathVariable Long id , @RequestBody Production production) {
		Production existingProduction = productionRepositroy.getOne(id);
		BeanUtils.copyProperties(production, existingProduction, "production_id");
		return productionRepositroy.saveAndFlush(existingProduction);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteProduction(@PathVariable Long id) {
		productionRepositroy.deleteById(id);
	}
}
