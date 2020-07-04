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

import com.example.BookProject.model.Printing_Service;
import com.example.BookProject.repository.PrintingServiceRepository;

@RestController
@RequestMapping("/printingService")
public class Printing_ServiceController {

	@Autowired
	private PrintingServiceRepository printingServiceRepository;
	
	@GetMapping
	public List<Printing_Service> getAll() {
		return printingServiceRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Printing_Service getOne(@PathVariable Long id) {
		return printingServiceRepository.getOne(id);
	}
	
	
	@PostMapping
	public Printing_Service createPS(@RequestBody Printing_Service printingService) {
		return printingServiceRepository.saveAndFlush(printingService);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Printing_Service updatePS(@PathVariable Long id , @RequestBody Printing_Service printingService) {
		Printing_Service oldPS = printingServiceRepository.getOne(id);
		BeanUtils.copyProperties(printingService, oldPS, "printing_service_id");
		return printingServiceRepository.saveAndFlush(oldPS);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deletePS(@PathVariable Long id) {
		 printingServiceRepository.deleteById(id);
	}
}
