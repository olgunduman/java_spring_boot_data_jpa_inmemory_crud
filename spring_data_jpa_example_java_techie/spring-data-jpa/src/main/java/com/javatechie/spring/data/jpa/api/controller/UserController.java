package com.javatechie.spring.data.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.data.jpa.api.model.User;
import com.javatechie.spring.data.jpa.api.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public List<User> getAll(){
		return userService.getUsers();
	}
	
	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession){
		
		return userService.getUserByProfession(profession);
		
	}
	
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age){
		long count = userService.getCounts(age);
		return "total no of recor :" + count;
		
	}
	
	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable String name){
		return userService.deleteUser(name);
		
	}
	
	@GetMapping("/findMultiCondition/{profession}/{age}")
	public List<User> getUsersByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
		
			return userService.getUsersByProfessionAndAge(profession,age);
	}
	
	@GetMapping("/getUsersIgnoreCase")
	public List<User> getUsersByProfession(@RequestParam("profession") String profession){
		
			return userService.getUsersIgnoreCase(profession);
	}
	
	@GetMapping("/getRecordsByCustomQuery")
	public List<User> getUsersCustomQuery(){
		return userService.getUsersCustomQuery();
	}
}
