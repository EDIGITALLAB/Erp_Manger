package com.example.erp.services;

import java.util.List;

import com.example.erp.payloads.UserDto;

public interface UserService {
	
	//create
	UserDto createUser(UserDto user);
	//update
	UserDto upadteUser(UserDto user,Integer userId);
	//get single
	UserDto getUserById(Integer userId);
	//get all
	List<UserDto> getAllUsers();
	//delete
	void deleteUser(Integer userId);

}
