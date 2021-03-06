package com.javatechie.spring.data.jpa.api.service;

import java.util.List;

import com.javatechie.spring.data.jpa.api.model.User;

public interface UserService {

	void initDb();
	List<User> getUsers();
	List<User> getUserByProfession(String profession);
	public long getCounts(int age);
	public List<User> deleteUser(String name);
	public List<User> getUsersByProfessionAndAge(String profession, int age);
	
	public List<User> getUsersIgnoreCase(String profession);
	
	public List<User> getUsersCustomQuery();
	
	
}
