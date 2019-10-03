package edu.eci.ieti.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.aplication.persistences.repositories.ITaskRepository;



@RestController
public class Controller {

	@Autowired
	ITaskRepository taskRepository;
	
	@RequestMapping(value="/prueba1",method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(){
	    try {
	  
	    	//testRepository.findAll();
	        return new ResponseEntity<>(taskRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("mal",HttpStatus.NOT_FOUND);
	    }
    }
}