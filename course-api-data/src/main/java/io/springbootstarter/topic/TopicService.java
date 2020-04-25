package io.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
//this is singleton class. It gets initialized during server startup
public class TopicService {
	@Autowired// to inject dependency
	TopicRepository topicRepository;
	
	private List<Topic> topicsList = 
			Arrays.asList(new Topic("java","1.8","java description"),
					new Topic("java_1","1.8_1","java_1 description"),
					new Topic("java_2","1.8_2","java_2 description"));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		//findAll()- CurdRepository method to fetch all records
		topicRepository.findAll()
		.forEach(topics :: add);
		// method reference is used iterate using forEach() , topics is list to be added and 'add' is method reference
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		//save() - CurdRepository method to save 
		topicRepository.save(topic);
	}

}
