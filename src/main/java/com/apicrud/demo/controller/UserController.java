package com.apicrud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicrud.demo.bean.UserBean;
import com.apicrud.demo.dao.UserDao;

@RestController
public class UserController 
{
	@Autowired
	UserDao userDao;
	
	@GetMapping("/home")
	public String homepage()
	{
		System.out.println("I am from home");
		
		return "<h1>This is a Home Page.</h1>";
	}
	
	@GetMapping("/allusers")
	@ResponseBody
	public ResponseEntity<List<UserBean>> getAllUsers() 
	{
		System.out.println("I am from allusers");
		return ResponseEntity.ok().body(userDao.getTable());
	}
	
	@GetMapping("/newuser")
	public Object newUser()
	{
		System.out.println("I am from newuser");
		return userDao.addUser();
	}
	
	@GetMapping("/deleteuser")
	public Object deleteUser()
	{
		System.out.println("I am from deletuser");
		return userDao.deleteUser();
	}
	
	@GetMapping("/updateuser")
	public Object updateUser()
	{
		System.out.println("I am from update user");
		return userDao.updateUser();
	}

}

