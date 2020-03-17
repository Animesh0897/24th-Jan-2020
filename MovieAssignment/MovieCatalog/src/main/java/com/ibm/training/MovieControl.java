package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieControl {
	
	@Autowired
	MovieService service;
	
	@GetMapping("/viewall")
	Iterable<Movie> getUsers() {
		return service.getUsers();
	}
	
	@PutMapping("/add")
	void addMovie(@RequestBody Movie movie) {
		service.addUser(movie);	
	}
}