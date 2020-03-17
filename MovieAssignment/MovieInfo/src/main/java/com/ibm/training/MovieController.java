package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/second")
public class MovieController {
	@Autowired
	MovieService service;

	@RequestMapping("/viewall")
	List<Object> getMovieById() {
		return service.getAllMovies();
	}

}
