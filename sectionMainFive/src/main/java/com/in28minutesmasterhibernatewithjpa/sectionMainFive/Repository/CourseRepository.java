package com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Course;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Review;

import java.util.*;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public Course findById(long Id) {
		return em.find(Course.class, Id);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) em.persist(course);
		// we can only use this as well
		return em.merge(course);
	}
	
	public boolean deleteById(long Id) {
		Course course = findById(Id);
		if(course == null) return false;
		em.remove(course);
		return true;
	}
	
	public void playingWithEntityManager() {
		logger.info("Inside the playing with entity manager method");
		Course course = new Course("Playing with entity Manager");
		em.persist(course);
		course.setName("Tapochek");
		logger.info("End of the method  name updated to {}" + course.getName());
	}
	// methods covered are flush, refresh, detach and clear
	public void playingWithEntityManagerMethods() {
		Course c1 = new Course("C1 course");
		Course c2 = new Course("C2 course");
		Course c3 = new Course("demo refresh course");
		em.persist(c1);
		logger.trace("Id of c1 course => {}");
		em.flush();
		logger.trace("Id of c1 course after persist to database => {}", c1.getId());
		// entity manager will not track and update changes 
		em.detach(c2);
		c1.setName("C1 course will be updated");
		em.flush();
		logger.trace("Name of c1 course after update to C1 course will be updated=> {}", c1.getName());
		em.clear();
		
		c1.setName("Will I be changed");
		em.flush();
		logger.trace("Name of c1 course after update to Will I be changed=> {}", c1.getName());
		
		logger.trace("Working with refresh operation with course c3");
		c3.setName("Babi MOn");
		em.persist(c3); 
		em.flush();
		logger.trace("Saved demo refresh course c3 course");
		c3.setName("changed course name");
		logger.trace("Changed c3 course name to {}", c3.getName());
		logger.trace("WIll use em refresh to get back the old name");
		em.refresh(c3);
		logger.trace("New name of c3 after refresh {}", c3.getName());
		System.out.println(c3.getName());
	}
	
	public void addReviewsToCourse() {
		// Retrieve the course to add reviews
		Course course = findById(10002);
		// show the existing reviews
		logger.info(course.getName() + " has the following reviews -> {}", course.getReviews());
		
		Review review1 = new Review("5", "Great Hands-off stuff");
		Review review2 = new Review("3", "Accent is problem");
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsToCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("Course with courseId is {}", course);
		
		for(Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
	
}
