package com.ritubrata.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
			
	}
	
	@RequestMapping("/topics/{anything}")  //if we use id instead of anything then no need to write ("anything")
	public Optional<Topic> getTopic(@PathVariable("anything") String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{anything}")
	public void updateTopic(@RequestBody Topic topic , @PathVariable("anything") String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{anything}")
	public void deleteTopic(@PathVariable("anything") String id) {
		topicService.deleteTopic(id);
	}

}
