package edu.eci.ieti.aplication.persistences.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.aplication.model.Task;



public interface ITaskRepository extends MongoRepository <Task, String> {
	 List<Task> findAllByOwner(String responsable);


}
