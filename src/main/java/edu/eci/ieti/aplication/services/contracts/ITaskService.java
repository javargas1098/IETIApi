package edu.eci.ieti.aplication.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.exception.TaskPlannerException;

@Service
public interface ITaskService {
	List<Task> getTasksList();

	Task getTask(String responsable) throws TaskPlannerException;

	List<Task> getTasksByUserId(String userId);

	Task assignTaskToUser(String taskId, User user) throws TaskPlannerException;;

	void removeTask(String taskId);

	Task updateTask(Task task);
	
	 Task createTask(Task task);
}