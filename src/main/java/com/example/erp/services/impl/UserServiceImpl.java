package com.example.erp.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erp.exception.*;
import com.example.erp.enttity.User;
import com.example.erp.payloads.UserDto;
import com.example.erp.repositoy.UserRepository;
import com.example.erp.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto upadteUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		user.setName(userDto.getName());
		user.setGender(userDto.getGender());
		user.setEmail(userDto.getEmail());
		//user.setImage(userDto.getImage());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
		user.setStatus(userDto.isStatus());
		user.setUsername(userDto.getUsername());
		user.setPersonalAddress(userDto.getPersonalAddress());
		
		
		
		User upadteUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(upadteUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		
		List <UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	//convate Dto To User
	public User dtoToUser(UserDto userDto) {
		
		//Auto mapping
		User user = this.modelMapper.map(userDto, User.class);
		
//Menually mapping
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setGender(userDto.getGender());
//		user.setEmail(userDto.getEmail());
//		user.setImage(userDto.getImage());
//		user.setPassword(userDto.getPassword());
//		user.setPhone(userDto.getPhone());
//		user.setStatus(userDto.isStatus());
//		user.setUsername(userDto.getUsername());
//		user.setUserStatus(userDto.getUserStatus());
	return user;
	}
	
	//convate User To Dto
	public UserDto userToDto(User user) {
		//auto mapping
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
  //menually mapping
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setGender(user.getGender());
//		userDto.setEmail(user.getEmail());
//		userDto.setImage(user.getImage());
//		userDto.setPassword(user.getPassword());
//		userDto.setPhone(user.getPhone());
//		userDto.setStatus(user.isStatus());
//		userDto.setUsername(user.getUsername());
//		userDto.setUserStatus(user.getUserStatus());
		return userDto;
		
	}

}
