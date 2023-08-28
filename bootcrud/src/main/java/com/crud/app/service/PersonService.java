package com.crud.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.crud.app.model.Person;
import com.crud.app.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	public Person savePerson(Person person) {
		
		return repository.save(person);
	}

	public List<Person> getAllPersons() {
		return repository.findAll();
	}

	public Person updatePerson(Person person, int id) {
		Optional<Person> findPerson = repository.findById(id);
		if(findPerson.isPresent()) {
			return repository.save(person);
		}
		return null;
	}

	public Optional<Person> getPerson(int id) {
		return repository.findById(id);
	}

	public String deletePerson(int id) {
		Optional<Person> optional = repository.findById(id);
		if(optional.isPresent()) {
			repository.deleteById(id);
			return "Data is deleted";
		}
		return "Data not found";
	}

	public Page<Person> getPersonByPage(Optional<Integer> pageData, Optional<String> sortBy) {
		
		return repository.findAll(PageRequest.of(
				pageData.orElse(0), 
				2, 
				Direction.DESC, 
				sortBy.orElse("id")));
	}

	public List<Person> searchByAddress(String query) {
		return repository.searchByAddress(query);
	}
}
