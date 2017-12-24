package or.ashish.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.ashish.springboot.model.CourseModel;
import or.ashish.springboot.repository.CourseRepository;

/*
 * We have to configure the class to be a bussiness service using @Service from stereotype package
 * */

@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	public List<CourseModel> getCourses(String id)
	{
		List<CourseModel> Courses = new ArrayList<>();
		courseRepository.findByTopicModelId(id).forEach(Courses::add);
		return Courses;
	}
	
	public CourseModel getCourse(String id)
	{
		//Find the Course using lamda operation
		//return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(CourseModel CourseModel) {
		courseRepository.save(CourseModel);
		
	}

	public void updateCourse(CourseModel CourseModel) {
		
		courseRepository.save(CourseModel);
		
	}
	
	public void deleteCourse(String id) {
		
		courseRepository.delete(id);
	}

}
