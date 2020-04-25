package io.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	//CrudRepository<Topic, String> - Topic- Entity class, String - Primary key

}
