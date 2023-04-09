package com.in28minutesmasterhibernatewithjpa.sectionMainFive.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplication;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.CourseRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.StudentRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Course;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Passport;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Student;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplicationTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SectionMainFiveApplication.class)
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
//	@Transactional
//	public void demoEagerfetch_studentthenpassport() {
//		Student student = repository.findById(20001);
//		logger.info("Student details are as follows -> {}", student);
//		logger.info("Student details are as follows -> {}", student.getPassport());
//	}
//	
//	@Test
//	@Transactional
//	public void demoEagerfetch_passportthenstudent() {
//		Passport passport = em.find(Passport.class, 40001L);
//		logger.info("Passport details are as follows -> {}", passport);
//		logger.info("Student details related to passport are as follows -> {}", passport.getStudent());
//	}
//	
//	@Test
//	@Transactional
//	public void someMethodWithChange() {
//		Passport passport = new Passport("E1B89000");
//		Student student = new Student("Current Student");
//		
//		em.persist(student);
//		em.persist(passport);
//		
//		em.flush();
//		student.setName("Somnath Roy");
//		passport.setNumber("asdasd");
////		int a = 5 / 0;
//	}
	
//	@Test
//	public void testWithoutTransaction(){
//		Student student = new Student("Current Student");
//		// insert operation
//		em.persist(student);
//		
//		student.setName("Funny student");
//	}
//	
	
	@Test
	@Transactional
	public void relationshipReadWithOutTransaction() {
		Student existingStudent = em.find(Student.class, 20001L);
		logger.info("Student at 20001 {}", existingStudent);
		Passport relatedPassport = existingStudent.getPassport(); 
		logger.info("Related passport {}", relatedPassport);
	}
}
