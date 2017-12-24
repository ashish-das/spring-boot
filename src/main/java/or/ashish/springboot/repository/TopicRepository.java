package or.ashish.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import or.ashish.springboot.model.TopicModel;

public interface TopicRepository extends CrudRepository<TopicModel,String> {

}
