package edu.eci.ieti.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.aplication.model.Task;
import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.persistences.repositories.ITaskRepository;
import edu.eci.ieti.aplication.services.TaskService;
import edu.eci.ieti.aplication.services.UserService;



@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class taskController {

	 @Autowired
	    private TaskService taskService;

	    @Autowired
	    private UserService userService;
	
	    @GetMapping
	    public ResponseEntity<?> getTasks() {
	        try {
	            return new ResponseEntity<>(taskService.getTasksList(), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getTaskById(@PathVariable("id") String id) {
	        try {
	            return new ResponseEntity<>(taskService.getTask(id), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/byUser/{userId}")
	    public ResponseEntity<?> getTasksByUserId(@PathVariable("userId") String userId) {
	        try {

	            return new ResponseEntity<>(taskService.getTasksByUserId(userId), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<?> createTaskHandler(@RequestBody Task task) {
	        try {
	            return new ResponseEntity<>(taskService.createTask(task), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/update")
	    public ResponseEntity<?> updateTaskHandler(@RequestBody Task task) {
	        try {
	            return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/assign/{taskId}")
	    public ResponseEntity<?> assignTaskHandler(@PathVariable("taskId") String taskId, @RequestBody User user) {
	        try {
	            return new ResponseEntity<>(taskService.assignTaskToUser(taskId, user), HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteTaskHandler(@PathVariable String id) {
	        try {
	            taskService.removeTask(id);
	            return new ResponseEntity<>(HttpStatus.ACCEPTED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }
}