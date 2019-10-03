package edu.eci.ieti.aplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.persistences.IMongoRepository;
import edu.eci.ieti.aplication.services.contracts.IUserService;
import edu.eci.ieti.exception.TaskPlannerException;

@Service
public class UserService implements IUserService {

	@Autowired
	private IMongoRepository userRepository;

	@Override
	public List<User> getUsersList()  {
		return userRepository.getUsers();
	}

	@Override
	public User getUser(String responsable) throws TaskPlannerException {
		return userRepository.getUser(responsable);
	}

	@Override
	public User createUser(User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		return userRepository.saveUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(user);
	}

	@Override
	public void removeUser(String responsable) {
		// TODO Auto-generated method stub
		userRepository.removeUser(responsable);

	}
}
