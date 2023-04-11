package com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.*;
import javax.persistence.JoinColumn;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	public Long Id;
	
	@Column(nullable=false)
	public String name;
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}

	@OneToOne(fetch=FetchType.LAZY)
	public Passport passport; 
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSE",
	joinColumns =  @JoinColumn(name="STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();
	
	protected Student() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + name + "]";
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
}
