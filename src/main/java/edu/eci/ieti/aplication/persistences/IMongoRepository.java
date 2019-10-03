package edu.eci.ieti.aplication.persistences;

import java.util.List;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.exception.TaskPlannerException;

public interface IMongoRepository {
	List<Task> getTasks();

    List<Task> getTasksByResponsable(String responsable);

    Task getTask(String id) throws TaskPlannerException;

    Task saveTask(Task task);

    Task updateTask(Task task);

    void removeTask(String id);

    Task assignTaskToUser(String taskId, User user) throws TaskPlannerException;
    
    List<User> getUsers();

    User getUser(String responsable) throws TaskPlannerException;

    User saveUser(User user) throws TaskPlannerException;

    User updateUser(User user);

    void removeUser(String responsable);

}
