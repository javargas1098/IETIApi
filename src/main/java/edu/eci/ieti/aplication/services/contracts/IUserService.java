package edu.eci.ieti.aplication.services.contracts;

import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.exception.TaskPlannerException;

@Service
public interface IUserService {
    List<User> getUsersList() throws SQLException;

    User getUser(String responsable) throws TaskPlannerException;

    User createUser(User user) throws TaskPlannerException;

    User updateUser(User user) throws TaskPlannerException;

    void removeUser(String reponsable) throws TaskPlannerException;
}
