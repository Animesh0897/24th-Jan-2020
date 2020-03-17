package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
	MovieRep repo;
	
	Iterable<Movie> getUsers(){
		return repo.findAll();
	}
	
	void addUser(Movie movie) {
		repo.save(movie);
	}
	

}
