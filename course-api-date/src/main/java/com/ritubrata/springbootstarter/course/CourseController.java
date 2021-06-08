package com.ritubrata.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritubrata.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{anything}/courses")
	public List<Course> getAllCourses(@PathVariable("anything") String id) {
		return courseService.getAllCourses(id);
			
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")  
	public Optional<Course> getCourse(@PathVariable("courseId") String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping(value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping(value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course , 
			@PathVariable("topicId") String topicId, 
			@PathVariable("courseId") String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping(value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") String id) {
		courseService.deleteCourse(id);
	}

}
