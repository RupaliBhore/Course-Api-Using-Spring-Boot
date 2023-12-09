package com.springresr.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springresr.springrest.entity.Course;
import com.springresr.springrest.serviceses.CourseService;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
	
	
	//serices ko call karane ke liye hume service ka hume object chiye
	//spring app ko batane ge ki aap mere liye isaka object create karo to mai @Autowired is annotaion se spring ko pata
	//chalega ki use CourseService is class ko jisane implement kiya he usaka object banana he( CourseServiceImpl)
	@Autowired
	private CourseService  courseService;
	
	
	
	//MVC me hum RequestMappping use karte he par yaha pe restapi bana rahe ye to method annotation hi use karaene honge
	//requstMapping me method change karani he to method batani ye to yese batate ho
	//RequestMapping(path="/courses",method = RequstMethod.GET)
	
	//get method me home fire hoga to ye function chale
	@GetMapping("/home")
	public String home()
	{
		return "this is home ";
	}
	
	
	
	                               //get All the courses
	
	@GetMapping("/courses")
	public List<Course> getCourese()
	{
		//muze sare courses chiye to me khud se to courses nikal nahi sakata matlab controoler khud se to kam nahi 
		//kar sakata to ye service ko request karega ki muze sare courses dedo
		
		//courseService is wale interface ka getCourses() ye wala method call hoga isaki body Impl class me he to
		//body call ho jayegi aur result milega jo us body me he
		return this.courseService.getCourses();
		
	}
	
	
	  
	                                  //get single course by id
	
	@GetMapping("/courses/{courseId}")
	//{courseId} is value ko get karane ke liye @PathVariable us karo aur ye value
	                                            //is verible me aayegi aur ye verible chala jayega service ke pass
	//getCourse(courseId);yaha pe aur services me hum banayenege getCourse ka ek method
	public Course getCourse(@PathVariable String courseId)
	{
		//courseService is wale interface ka getCourses() ye wala method call hoga isaki body Impl class me he to
				//body call ho jayegi aur result milega jo us body me he
		//String courseId) string courseId ko long me convert karo kyuki humane courseId long type diya he
	     return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	
	                        //ADD NEW COURSE
	
	//data json format me ane wale he ye batao
	@PostMapping("/courses")
	
	//Courese ko object apako milega requst body se
	public Course addCourse(@RequestBody  Course course)
	{
		
		return this.courseService.addCourse(course);
		
	}
	
	
	
	
	//UPADTE THE COURSE
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	
	
	//Http status code 200 400 500
	
	//DELETE THE COURSE
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(Exception e)
		{
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	

}
