package com.crud.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.app.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

//	@Query(value = "select * from person where address like concat('%', :query)", nativeQuery = true)
//	List<Person> searchByAddress(String query);
	
	@Query("select p from person p where p.address like concat('%', :query)")
	List<Person> searchByAddress(String query);
}
