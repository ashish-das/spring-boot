package or.ashish.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import or.ashish.springboot.model.CourseModel;

public interface CourseRepository extends CrudRepository<CourseModel,String> {
	
	public List<CourseModel> findByTopicModelId(String topicId);

}
