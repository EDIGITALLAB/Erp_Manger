package com.example.erp.services;

import java.util.List;

import com.example.erp.enttity.Post;
import com.example.erp.payloads.PostDto;
import com.example.erp.payloads.PostResponse;

public interface PostService {
	
	
	//create 
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update 
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete 
	void deletePost(Integer postId);
	
	//get all post ---List<PostDto> change  PostResponse
	PostResponse getAllPost(Integer pageNumber,Integer pageSize);
	
	//get single post 
	PostDto getPostById(Integer postId);
	
	
	// get all post category 
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);

}
