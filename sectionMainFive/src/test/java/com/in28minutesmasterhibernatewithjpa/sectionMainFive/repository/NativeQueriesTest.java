package com.in28minutesmasterhibernatewithjpa.sectionMainFive.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.SectionMainFiveApplicationTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=SectionMainFiveApplication.class)
public class NativeQueriesTest {
	@Autowired
	private EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Using SELECT * from table using native queries
	
	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE  where id = ? -> {}", resultList);
		//[Course[JPA in 50 Steps - Updated]]
	}

	@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM COURSE  where id = :id -> {}", resultList);
		//[Course[JPA in 50 Steps - Updated]]
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("Update COURSE set last_updated_date=CURRENT_TIMESTAMP");
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated  -> {}", noOfRowsUpdated);
		//SELECT * FROM COURSE  -> [Course[Web Services in 100 Steps], Course[JPA in 50 Steps - Updated], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
	}

}
