package com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Passport;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public Student findById(long Id) {
		return em.find(Student.class, Id);
	}
	
	public Student save(Student student) {
		if(student.getId() == null) em.persist(student);
		// we can only use this as well
		return em.merge(student);
	}
	
	public boolean deleteById(long Id) {
		Student student = findById(Id);
		if(student == null) return false;
		em.remove(student);
		return true;
	}
	// Caused by: org.hibernate.PropertyValueException: not-null property references a null or transient value : com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Student.name
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
		em.persist(student);
	}	
	
	public void someMethodWithChange() {
		Passport passport = new Passport("E1B89000");
		Student student = new Student("Current Student");
		
		em.persist(student);
		em.persist(passport);

		em.flush();
//		em.getTransaction().commit();
		logger.info("Saved Student {}", em.find(Student.class, student.getId()));
		logger.info("Saved passport {}", em.find(Passport.class, passport.getId()));
		student.setName("new name");
		passport.setNumber("asdasd");
//		int a = 5 / 0;
	}
	
}
