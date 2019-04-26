package com.hcl.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.User;
import com.hcl.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("")
	public String getUser() {
		return "inside getuser";
	}

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("Successfully inserted", HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<User> getAll() {
		return userService.getAll();
	}

	@DeleteMapping("/user")
	public void deleteById(@RequestParam(value = "id") Integer id) {
		System.out.println("id----------- " + id);
		userService.deleteUser(Long.valueOf("" + id));
	}

	@DeleteMapping("/user/{id}")
	public void deleteById11(@PathVariable(value = "id") Integer id) {
		System.out.println("id----------- " + id);
		userService.deleteUser(Long.valueOf("" + id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id) {

		User userUpdate=userService.findById(id);
		return new ResponseEntity<String>("Record updated", HttpStatus.OK);
	}
   
	@GetMapping("/findbyname")
	public List<User> findByName(@RequestParam String name){
		return userService.findByName(name);
		
	}
	
}
