package com.example.erp.enttity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="users")
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String name;
	@Column(unique = true)
	private String email;
	private String phone;
	private String password;
	private boolean status;
//	@Column(length = 500)
//	private String image;
	private String gender;
	private String personalAddress;
	
	private String userStatus;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();
	
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
		  if(status == true) {
	            userStatus = "Active";
	        }
	        else if(status == false) {
	            userStatus = "Inactive";
	        }
	}


//	public String getImage() {
//		return image;
//	}
//
//
//	public void setImage(String image) {
//		this.image = image;
//	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public String getPersonalAddress() {
		return personalAddress;
	}


	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}
	
	
	

}
