INSERT into Course (id, name, created_date, last_updated_date) VALUES (10001, 'Master JPA and JDBC Spring', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT into Course (id, name, created_date, last_updated_date) VALUES (10002, 'Learn Hibernate', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT into Course (id, name, created_date, last_updated_date) VALUES (10003, 'Spring Boot in 1000 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT into Course (id, name, created_date, last_updated_date) VALUES (10004, 'Functional Programming in Java', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description, course_id)
values(50001,'5', 'Great Course', 10001);
insert into review(id,rating,description, course_id)
values(50002,'4', 'Wonderful Course', 10001);
insert into review(id,rating,description, course_id)
values(50003,'5', 'Awesome Course', 10002);

insert into student_course(STUDENT_ID, COURSE_ID)
values(20001, 10001);
insert into student_course(STUDENT_ID, COURSE_ID)
values(20002, 10002);
insert into student_course(STUDENT_ID, COURSE_ID)
values(20003, 10003);
insert into student_course(STUDENT_ID, COURSE_ID)
values(20001, 10001);
