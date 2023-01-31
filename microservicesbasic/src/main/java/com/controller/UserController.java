package com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	//add user
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
		String randomUUID = UUID.randomUUID().toString();
		user.setUserid(randomUUID);
		UserEntity userS = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userS);
	}
	
	//get single user
	@GetMapping("/{userid}")
	public ResponseEntity<UserEntity> getSingleUser(@PathVariable String userid){
		UserEntity user = userService.getUser(userid);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	//get all user
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> users = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	
	
}
