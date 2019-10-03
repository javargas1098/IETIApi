package edu.eci.ieti.aplication.persistences.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.persistences.IMongoRepository;
import edu.eci.ieti.aplication.persistences.repositories.ITaskRepository;
import edu.eci.ieti.aplication.persistences.repositories.IUserRepository;
import edu.eci.ieti.exception.TaskPlannerException;

@Service
public class MongoRepositoryImp implements IMongoRepository {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ITaskRepository taskRepository;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String responsable) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(responsable);
		if (user.isPresent())
			return user.get();
		throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
	}

	@Override
	public User saveUser(User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		if (userRepository.existsById(user.getUserName()))
			throw new TaskPlannerException(TaskPlannerException.USER_ALREADY_EXISTS);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void removeUser(String responsable) {
		// TODO Auto-generated method stub
		userRepository.deleteById(responsable);

	}
	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public List<Task> getTasksByResponsable(String responsable) {
		// TODO Auto-generated method stub
		return taskRepository.findAllByOwner(responsable);
	}

	@Override
	public Task getTask(String id) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Optional<Task> task = taskRepository.findById(id);
		if (task.isPresent())
			return task.get();
		throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
	}

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public void removeTask(String id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);

	}

	@Override
	public Task assignTaskToUser(String taskId, User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Task task = getTask(taskId);
		task.setOwner(user);
		return updateTask(task);
	}

}
