package or.ashish.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.ashish.springboot.model.TopicModel;
import or.ashish.springboot.repository.TopicRepository;

/*
 * We have to configure the class to be a bussiness service using @Service from stereotype package
 * */

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<TopicModel> topics = new ArrayList<>(Arrays.asList(
			new TopicModel("Java 1.8","Java 1.8","Guide to spring"),
			new TopicModel("Struts2","Struts 2.4","Struts MVC"),
			new TopicModel("Spring","Spring 5.0.2","Spring MVC")
			));
	
	public List<TopicModel> getTopics()
	{
		List<TopicModel> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public TopicModel getTopic(String id)
	{
		//Find the topic using lamda operation
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(TopicModel topicModel) {
		
		topicRepository.save(topicModel);
		
	}

	public void updateTopic(TopicModel topicModel, String id) {
		
		topicRepository.save(topicModel);
		
	}
	
	public void deleteTopic(String id) {
		
		topicRepository.delete(id);
	}

}
