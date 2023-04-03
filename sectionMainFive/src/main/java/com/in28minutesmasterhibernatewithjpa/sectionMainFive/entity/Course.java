package com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Course")
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'")
})
public class Course{
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	protected Course() {
		
	}
	// Managed by hibernate
	// created time
	@CreationTimestamp
	private LocalDateTime createdDate;
	// updated time
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@Override
	public String toString() {
		return "Course [Id=" + id + ", name=" + name + "]";
	}

	public Course(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
}