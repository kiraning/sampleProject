package com.hcl.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	public User findById(Long id) {
		
		User user= userRepository.findById(id).get();
		//user.setId(Long.valueOf(12));
		user.setName("Hetvik");
		return userRepository.save(user);
	}
	
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
		
	}

}
