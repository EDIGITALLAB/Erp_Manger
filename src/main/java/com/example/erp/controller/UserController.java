package com.example.erp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.erp.payloads.ApiResponse;
import com.example.erp.payloads.UserDto;
import com.example.erp.services.FileService;
import com.example.erp.services.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private FileService fileService;
	
	
	//variable path get(image)
	@Value("${project.image}")
	private String path;
	
	
	//Post create User   validation enabule use --- @Valid
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}
	//Put - update user
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer id){
		UserDto upadtedUser = this.userService.upadteUser(userDto, id);
		return ResponseEntity.ok(upadtedUser);
	}
	//Delete - delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
		this.userService.deleteUser(id);
		//return ResponseEntity.ok(Map.of("message", ("User delete Successfull..")));
		//or
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfull..", true), HttpStatus.OK);
		
	}
	//Get -user get all Users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	//Get user singleUser 
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer id) {
		return ResponseEntity.ok(this.userService.getUserById(id));

}
	
	
	//post image uploade
	
//	@PostMapping("/image/upload/{userId}")
//	public ResponseEntity<UserDto>uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable Integer userId) throws IOException{
//		
//		UserDto userDto = this.userService.getUserById(userId);
//		String fileName = this.fileService.UploadImage(path, image);
//		userDto.setImage(fileName);
//		UserDto upadteUser = this.userService.upadteUser(userDto, userId);
//		return new ResponseEntity<UserDto>(upadteUser, HttpStatus.OK);
	
//	}
	
	//method to serve files
//	@GetMapping(value = "/image/{image}",produces = MediaType.IMAGE_JPEG_VALUE)
//	public void downlodImage(@PathVariable("image") String image,HttpServletResponse response) throws IOException{
//		
//		InputStream resource = this.fileService.getResource(path, image);
//		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		StreamUtils.copy(resource,response.getOutputStream());
//		
//	}
}
