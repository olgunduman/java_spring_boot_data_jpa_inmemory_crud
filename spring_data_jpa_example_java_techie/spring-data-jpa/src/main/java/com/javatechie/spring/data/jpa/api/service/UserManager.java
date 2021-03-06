package com.javatechie.spring.data.jpa.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.spring.data.jpa.api.dao.UserRepository;
import com.javatechie.spring.data.jpa.api.model.User;

@Service
@Transactional
public class UserManager implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	@Override
	public void initDb() {
		List<User> users = new ArrayList<>();
		users.add(new User(111,"x","IT",23));
		users.add(new User(678,"y","IT",25));
		users.add(new User(542,"z","CIVIL",26));
		users.add(new User(152,"p","IT",24));
		users.add(new User(426,"q","GOVT",22));
		
		userRepository.saveAll(users);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserByProfession(String profession) {
		
		return userRepository.findByProfession(profession);
	}

	@Override
	public long getCounts(int age) {
		
		return userRepository.countByAge(age);
	}

	@Override
	public List<User> deleteUser(String name) {
		
		return userRepository.deleteByName(name);
	}

	@Override
	public List<User> getUsersByProfessionAndAge(String profession, int age) {
		
		return userRepository.findByProfessionAndAge(profession, age);
	}

	@Override
	public List<User> getUsersIgnoreCase(String profession) {
		
		return userRepository.findByProfessionIgnoreCase(profession);
	}

	public List<User> getUsersCustomQuery(){
		return userRepository.getUsersCustomQuery();
	}



}
