package com.springresr.springrest.serviceses;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springresr.springrest.dao.CourseDao;
import com.springresr.springrest.entity.Course;

//ye class services ko implement karegi spring boot ko batao ye service class he jisane serivise ko implemnt kiya he

@Service
public class CourseServiceImpl implements CourseService{
	
	
	//JpaRepository ke method se hum data pe CRUD opreation karenge
	//findAll() findById() 
	@Autowired
	private CourseDao  courseDao;
	
	
	
	//data ko store karane ke liye list banalo
	//List<Course> list;
	
	//constructor banate he
	public CourseServiceImpl() {
		
		
		
		
    // jise hi constructor ka object banega ek aarray list create hogi
//		list=new ArrayList<>();
//		
//		//list banalo courses ki
//		list.add(new Course(132,"java core","this course contain basic of java"));
//		list.add(new Course(134,"python","this is advance python course "));
//		list.add(new Course(135,"c++","this course contain basic of c++"));
				
	}

	

	//jaise aap getCourses() call karoge list ko return karega jismae 2 course add he
	
	@Override
	public List<Course> getCourses() {
		
		//list ko yaha se return kiya
		//return list;
		
		return courseDao.findAll();
	}



	@Override
	public Course getCourse(long courseId) {
		
		//Course c = null;
		
		//for each loop lagao aaray list ko travese kanae ke liye
//		for(Course course:list)
//		{
//			//course is verible me sare course fetch hoke anage to if lagao aur check karo courseki id aur jo bracket me id aa rahi
//			//he o match ho rahi he kya ho rahi he to use o list dedo jasehi id meligi for each loop ko braek karo
//			if(course.getId()== courseId)
//			{
//				//us course ko do aur loop break karo
//				c=course;
//				break;
//			}
//		}
//		
//		
//		
//		//jisaki id pass kiyi he wahi course ko return karana he
//		return c;
		
		return courseDao.getReferenceById(courseId);
	}



	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
//		return course;
		
		courseDao.save(course);
		return course;
	}



	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			
//			if(e.getId()==course.getId()) 
//			{
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//			
//			
//		});
//		
//		//upadte ke lie jparepo ke pass save() method hi he
		courseDao.save(course);
		return course;
	}



	@Override
	public void deleteCourse(long parseLong) {
		
		//list=this.list.stream().filter(e -> e.getId()!= parseLong).collect(Collectors.toList());
		
		//pahile entity ko load karo
		Course entity=courseDao.getReferenceById(parseLong);
		
		courseDao.delete(entity);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
