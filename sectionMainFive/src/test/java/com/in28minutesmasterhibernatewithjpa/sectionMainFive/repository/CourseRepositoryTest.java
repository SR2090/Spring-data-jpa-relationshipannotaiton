package com.in28minutesmasterhibernatewithjpa.sectionMainFive.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplication;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.CourseRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Course;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplicationTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SectionMainFiveApplication.class)
public class CourseRepositoryTest {
	@Autowired
	private CourseRepository repository;
	
	
	@Test
	@DirtiesContext
	public void findById_basic() {
		Course course = repository.findById(10001);
		assertEquals("Master JPA and JDBC Spring", course.getName());
	} 
	
	@Test
	@DirtiesContext
	public void findByDelete_basic() {
		long Id = 10001;
		boolean result = repository.deleteById(Id);
		assertTrue(result);
		assertNull(repository.findById(Id));
	}
	
	@Test
	@DirtiesContext
	public void save_update() {
		Course course = repository.findById(10001);
		assertEquals("Master JPA and JDBC Spring", course.getName());
		course.setName("Changed name");
		repository.save(course);
		Course updatedCourse = repository.findById(10001);
		assertEquals("Changed name", updatedCourse.getName());
	}
	
	@Test
	@DirtiesContext
	public void playingwithEM_test() {
		repository.playingWithEntityManager();
	}
	
}
