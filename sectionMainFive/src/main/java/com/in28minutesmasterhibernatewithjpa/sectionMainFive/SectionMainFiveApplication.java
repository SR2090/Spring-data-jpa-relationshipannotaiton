package com.in28minutesmasterhibernatewithjpa.sectionMainFive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutesmasterhibernatewithjpa.sectionMainFive.Repository.CourseRepository;
import com.in28minutesmasterhibernatewithjpa.sectionMainFive.entity.Course;

@SpringBootApplication
public class SectionMainFiveApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courserepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SectionMainFiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		logger.info("{} is value at Id 10001", courserepo.findById(10001).toString());
//		logger.info("Delete course with 10001 Id ---> {}", courserepo.deleteById(10001L));
//		logger.info("Adding new course without ID", courserepo.save(new Course("Outlandish course")));
//		courserepo.playingWithEntityManager();
//		logger.info("EM HAS BEEN EXECUTED");
//		logger.debug("*****Code runner starter Inside main");
//		courserepo.playingWithEntityManagerMethods();
	}

}
