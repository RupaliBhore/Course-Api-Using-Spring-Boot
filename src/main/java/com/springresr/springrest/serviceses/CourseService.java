package com.springresr.springrest.serviceses;

import java.util.List;

import com.springresr.springrest.entity.Course;

public interface CourseService {
	
	//ye ek service he jo return karati he all courses ko list me
	//intrface ye to isake andhar hum body nahi de sakate isase loose coupling ho jayega
	//to ek class banayege jo in services ko implement karati hogi
	
	//isaki body serviceImpl me he to jab ye call hoga to waha ki body me jo he o return hoga usane list return kiyi
	//he to list return hogi
	public List<Course> getCourses();
	
	
	//isaki body serviceImpl me he to jab ye call hoga to waha ki body me jo he o return hoga usane list return kiyi
		//he to list return hogi
	public Course getCourse(long courseId);
	
	
	//ADD COURSE
	public Course addCourse(Course course);
	
	
	//UPDATE COURSE
	public Course updateCourse(Course course);
	
	
	//DELETE COURSE
	public void deleteCourse(long parseLong);

}
