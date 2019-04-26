package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public List<User> getAll();
	
	public void deleteUser(Long id);
	
	public User findById(Long id);
	
	public List<User> findByName(String name);

}
