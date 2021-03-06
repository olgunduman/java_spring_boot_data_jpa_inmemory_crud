package com.javatechie.spring.data.jpa.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.javatechie.spring.data.jpa.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByProfession(String profession);
	
	public long countByAge(int age);
	
	public List<User> deleteByName(String name);
	
	//multiple condition
	public List<User> findByProfessionAndAge(String profession, int age);
	
	//arama kısmında büyük küçük harfe duyarlı olması için "IgnoreCase" kullandık
	public List<User> findByProfessionIgnoreCase(String profession);
	
	@Modifying
	@Query("select u from User u")
	public List<User> getUsersCustomQuery(); 
	
}
