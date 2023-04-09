package com.in28minutesmasterhibernatewithjpa.sectionMainFive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.CourseRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.StudentRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Review;

@SpringBootApplication
public class SectionMainFiveApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courserepo;
	
	@Autowired
	private StudentRepository studentrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SectionMainFiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("5", "Great Hands-off stuff"));
		reviews.add(new Review("3", "Accent is problem"));
		
		courserepo.addReviewsToCourse(10001L, reviews);
	}

}
