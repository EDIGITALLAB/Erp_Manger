package com.example.erp.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.enttity.Category;
import com.example.erp.enttity.Post;
import com.example.erp.enttity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	

}
