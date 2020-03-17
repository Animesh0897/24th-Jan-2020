package com.ibm.training;

import javax.persistence.Entity;

@Entity
public class Movie {
	String name , genre;
	int id;
	public Movie(String name, String genre, int id) {
		super();
		this.name = name;
		this.genre = genre;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
