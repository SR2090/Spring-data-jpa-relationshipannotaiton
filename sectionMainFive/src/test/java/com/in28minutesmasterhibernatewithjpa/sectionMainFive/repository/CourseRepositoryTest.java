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
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Course;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Review;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Student;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplicationTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SectionMainFiveApplication.class)
public class CourseRepositoryTest {
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@DirtiesContext
	public void findById_basic() {
		Course course = repository.findById(10001);
		assertEquals("Master JPA and JDBC Spring", course.getName());
	} 
	
//	@Test
//	@DirtiesContext
//	public void findByDelete_basic() {
//		long Id = 10001L;
//		boolean result = repository.deleteById(Id);
//		assertTrue(result);
//		assertNull(repository.findById(Id));
//	}
	
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
	
	@Test
	@Transactional
	public void fetchTypeManyToOne() {
		Course course = repository.findById(10001L);
		logger.info("The course {} -> ", course);
		logger.info("The associated reviews with the course {} ", course.getReviews());
	}
	
	@Test
	@Transactional
	public void fetchCourseGivenReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("The review {} ", review);
		logger.info("The associated course is {}",  review.getCourse());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		logger.info("The student {}", student);
		logger.info("The courses the student has taken {}", student.getCourses());
	}
}
