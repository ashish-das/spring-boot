package or.ashish.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import or.ashish.springboot.model.CourseModel;
import or.ashish.springboot.model.TopicModel;
import or.ashish.springboot.service.CourseService;

@RestController
public class Course {
	
	/* 
	 	* We declare the variable as autowired as the spring will do the dependency injection automatically 
	*/
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/course")
	public List<CourseModel> getAllCourse(@PathVariable String id)
	{
		return courseService.getCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public CourseModel getCourse(@PathVariable String courseId)
	{
		return courseService.getCourse(courseId);
	}
	
	/*
	 * The put request handler
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody CourseModel courseModel,@PathVariable String topicId)
	{
		courseModel.setTopicModel(new TopicModel(topicId,"",""));
		courseService.addCourse(courseModel);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody CourseModel courseModel,@PathVariable String topicId,@PathVariable String id)
	{
		courseModel.setTopicModel(new TopicModel(topicId,"",""));
		courseService.updateCourse(courseModel);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
}
