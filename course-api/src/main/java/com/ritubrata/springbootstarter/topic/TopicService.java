package com.ritubrata.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topicList = new ArrayList<>(Arrays.asList(new Topic("111", "Java", "Primary Basic knowledge"),
			new Topic("222", "Spring", "Second Basic knowledge"),
			new Topic("333", "Springboot", "Advance knowledge"))); 
	
	public List<Topic> getAllTopics(){
		return topicList;
	}
	
	public Topic getTopic(String id) {
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i <= topicList.size();i++) {
			Topic t = topicList.get(i);
			if(t.getId().equals(id)) {
				topicList.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic( String id) {
		topicList.removeIf(t->t.getId().equals(id));
		
	}

}
