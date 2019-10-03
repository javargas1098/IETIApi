package edu.eci.ieti.aplication.persistences.repositories;


import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



import edu.eci.ieti.aplication.model.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    public List<User> findAll();
}