package com.springresr.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springresr.springrest.entity.Course;
   
   //JpaRepository ko entity name aur us entity me primary key kis type ki he ye 2 argument do
//JpaRepository ke pass database se data ko fetch katene ke sare methods he
public interface CourseDao extends JpaRepository<Course, Long> {
	
	
	

}
