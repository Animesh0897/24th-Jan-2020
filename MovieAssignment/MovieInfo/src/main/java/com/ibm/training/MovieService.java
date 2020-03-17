package com.ibm.training;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieService {
	@Autowired
	RestTemplate template;
	

	@HystrixCommand(fallbackMethod = "stillWorks")
	public List<Object> getAllMovies() {
		String anotherServiceUrl = "http://movieassignment/movies/viewall";
		
		Object []dataFromOtherService = template.getForObject(anotherServiceUrl, Object[].class);
		
		return Arrays.asList(dataFromOtherService);
	}
	
	public List<Object> stillWorks(){
		return Arrays.asList(
				new Movie("Purge", "Action", 10)
		);
	}

}
