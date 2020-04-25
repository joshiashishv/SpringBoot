package io.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
//this is singleton class. It gets initialized during server startup
public class TopicService {
	
	private List<Topic> topicsList = 
			Arrays.asList(new Topic("java","1.8","java description"),
					new Topic("java_1","1.8_1","java_1 description"),
					new Topic("java_2","1.8_2","java_2 description"));
	
	public List<Topic> getAllTopics(){
		return topicsList;
	}
	
	public Topic getTopicById(String id) {
		return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topicsList.add(topic);
	}

}
