package com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	public Long Id;
	
	@Column(nullable=false)
	public String number;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	public Student student;
	
	protected Passport() {
		
	}

	public String getNumber() {
		return number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [Id=" + Id + ", number=" + number + "]";
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return Id;
	}
}
