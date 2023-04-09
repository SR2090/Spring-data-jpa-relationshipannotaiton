package com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	public Long Id;
	
	public String description;
	
	public String rating;
	
	@ManyToOne
	public Course course;
	
	protected Review() {
		
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Review [Id=" + Id + ", description=" + description + ", Rating=" + rating + "]";
	}
	
	
}
