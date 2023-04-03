package com.in28minutesmasterhibernatewithjpa.sectionMainFive.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplicationTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SectionMainFiveApplication.class)
public class JPQLNamedQueryTest {
	@Autowired
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// This method demonstrates the JPQL 
	// query to select all and return objects
	@Test
	public void genericJPQLSELECTALLCourses() {
		Query query = em.createQuery("SELECT c FROM Course c");
		List resultList = query.getResultList();
		logger.info("Result of the JPQL query SELECT c FROM Course c {} -> ", resultList);
	}
	
	@Test
	public void objectSpecificJPQLSELECTALLCourses() {
		TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Result of the JPQL query SELECT c FROM Course c -> {} ", resultList);
		logger.info("Type of query -> {} ", resultList.get(0).getClass());
	}
	
	@Test
	public void JPQLNamedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> result = query.getResultList();
		logger.info("The result of the query is as follows : {}",  result);
	}
	
	@Test
	public void JPQLNamedQuery2() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);
		List<Course> result = query.getResultList();
		logger.info("The result of the query is as follows : {}",  result);
	}
}
