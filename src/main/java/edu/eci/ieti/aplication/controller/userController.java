package edu.eci.ieti.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class userController {

	 @Autowired
	    private UserService userService;

	    @GetMapping
	    public ResponseEntity<?> getUsersHandler() {
	        try {
	            return new ResponseEntity<>(userService.getUsersList(), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getUsersByIdHandler(@PathVariable("id") String id) {
	        try {
	            return new ResponseEntity<>(userService.getUser(id), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping
	    public ResponseEntity<?> updateUserHandler(@RequestBody User user) {
	        try {
	            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteUserHandler(@PathVariable String id) {
	        try {
	            userService.removeUser(id);
	            return new ResponseEntity<>(HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

}
