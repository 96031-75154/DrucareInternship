package com.crud.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.app.model.Person;
import com.crud.app.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService service;
	
	@PostMapping("/create")
	public Person savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}
	
	@GetMapping("/allPersons")
	public List<Person> getAllPersons() {
		return service.getAllPersons();
	}
	
	@PutMapping("/update/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable int id) {
		return service.updatePerson(person, id);
	}
	
	@GetMapping("/getPerson/{id}")
	public Optional<Person> getPerson(@PathVariable int id) {
		return service.getPerson(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePerson(@PathVariable int id) {
		return service.deletePerson(id);
	}
	
	@GetMapping("/page")
	public Page<Person> getPersonByPage(@RequestParam("pageCount") Optional<Integer> pageData, @RequestParam("sorted") Optional<String> sortBy) {
		return service.getPersonByPage(pageData,  sortBy);
	}
	
	@GetMapping("/person/search")
	public List<Person> searchByAddress(@RequestParam("query") String query) {
		return service.searchByAddress(query);
	}
}
