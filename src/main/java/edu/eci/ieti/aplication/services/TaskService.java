package edu.eci.ieti.aplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.persistences.IMongoRepository;
import edu.eci.ieti.aplication.services.contracts.ITaskService;
import edu.eci.ieti.exception.TaskPlannerException;

@Service
public class TaskService implements ITaskService {
	
	@Autowired
	private IMongoRepository taskRepository;

	@Override
	public List<Task> getTasksList() {
		// TODO Auto-generated method stub
		return taskRepository.getTasks();
	}

	@Override
	public Task getTask(String responsable) throws TaskPlannerException {
		// TODO Auto-generated method stub
		return taskRepository.getTask(responsable);
	}

	@Override
	public List<Task> getTasksByUserId(String responsable) {
		// TODO Auto-generated method stub
		return taskRepository.getTasksByResponsable(responsable);
	}

	@Override
	public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		return taskRepository.assignTaskToUser(taskId, user);
	}

	@Override
	public void removeTask(String taskId) {
		// TODO Auto-generated method stub
		taskRepository.removeTask(taskId);
		
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.updateTask(task);
	}

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.saveTask(task);
	}



}
