package com.example.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
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

import com.example.erp.payloads.ApiResponse;
import com.example.erp.payloads.PostDto;
import com.example.erp.payloads.PostResponse;
import com.example.erp.services.PostService;



@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
	PostDto createPostDto = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPostDto,  HttpStatus.CREATED);
		
	}
	
	//update Post 
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto PostDto ,@PathVariable Integer postId){
		
		PostDto updatePost = this.postService.updatePost(PostDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
		
		
	}
	
	//Delete Post
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
		
		this.postService.deletePost(postId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post is successful delete !", true),HttpStatus.OK);
		
	}
	
	//Get all Post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize){
		
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize);
		
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
		
	}
	
	//Get Single Post
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postById = this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
		
	}
	
	
	//Get By Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK);
		
	}
	 //Get By User
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
	List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
	
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
		
	}

}
