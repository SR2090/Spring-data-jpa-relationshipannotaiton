package com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	public Long Id;
	
	@Column(nullable=false)
	public String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	public Passport passport; 
	
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
