package or.ashish.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import or.ashish.springboot.model.TopicModel;
import or.ashish.springboot.service.TopicService;

@RestController
public class Topic {
	
	/* 
	 	* We declare the variable as autowired as the spring will do the dependency injection automatically 
	*/
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<TopicModel> getAllTopic()
	{
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public TopicModel getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	/*
	 * The put request handler
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody TopicModel topicModel)
	{
		topicService.addTopic(topicModel);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	public void updateTopic(@RequestBody TopicModel topicModel,@PathVariable String id)
	{
		topicService.updateTopic(topicModel,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}
}
