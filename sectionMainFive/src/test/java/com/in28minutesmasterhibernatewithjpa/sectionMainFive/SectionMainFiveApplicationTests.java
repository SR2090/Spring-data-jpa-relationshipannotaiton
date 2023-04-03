package com.in28minutesmasterhibernatewithjpa.sectionMainFive;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SectionMainFiveApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	void contextLoads() {
		logger.info("Logging from test class SectionMainFiveApplicationTests");
		assertFalse(true);
	}

}
