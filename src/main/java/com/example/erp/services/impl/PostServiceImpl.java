package com.example.erp.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.erp.enttity.Category;
import com.example.erp.enttity.Post;
import com.example.erp.enttity.User;
import com.example.erp.exception.ResourceNotFoundException;
import com.example.erp.payloads.PostDto;
import com.example.erp.payloads.PostResponse;
import com.example.erp.repositoy.CategoryRepository;
import com.example.erp.repositoy.PostRepository;
import com.example.erp.repositoy.UserRepository;
import com.example.erp.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
//create and set imp ----------------------------------------------------->
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
	    //fetch user
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		
	    //fetch category
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		//set
		post.setImageName("default.png");
		post.setJoinDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		//save
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}
	
//Update Post------------------------------------------------------------------------------->
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		
		post.setWork(postDto.getWork());
		post.setAddress(postDto.getAddress());
		post.setImageName(postDto.getImageName());
		
		Post updatePost = this.postRepo.save(post);
		
		return this.modelMapper.map(updatePost, PostDto.class);
	}
	
//Delete Post--------------------------------------------------------------------------->
	@Override
	public void deletePost(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		
			this.postRepo.delete(post);
	}
	
//Get all post imp----------------------------------------------------------------------------->
	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {
		
		//pagination
		//Page-able object and method of pass - pageNumber, pageSize
		Pageable p = PageRequest.of(pageNumber, pageSize);
		//fetch pagePost
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		//fetch Post
		List<Post> allPost = pagePost.getContent();
		
		//convate post To PostDto
		List<PostDto> postDtos = allPost.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		
		//return PostResponse ---create object
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		
		return postResponse;
	}
	
//Get single post imp------------------------------------------------------------>
	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		//return convate post to postDto
		return this.modelMapper.map(post, PostDto.class);
	}
	
//Get all post category imp------------------------------------------------------------------>
	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		//fetch category
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		//fetch post
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		//convate post To postDto
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}
	
//Get all post by user imp-------------------------------------------------------------------------->
	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		//fetch user
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		//fetch post
		List<Post> posts = this.postRepo.findByUser(user);
		//convate user To postDto
		List<PostDto> PostDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return PostDtos;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
