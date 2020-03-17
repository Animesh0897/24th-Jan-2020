package com.ibm.training;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRep extends CrudRepository<Movie, Integer> {
	

}
