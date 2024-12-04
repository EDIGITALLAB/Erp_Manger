package com.example.erp.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 3, max = 15 , message = "UserName must be min of 3 character and max 15 character !! ")
	private String username;
	
	@NotEmpty
	@Size(min = 4, message = "Name must be min of 4 characters !!")
	private String name;
	
	@Column(unique = true)
	@Email(message = "Your Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=0,max=10, message = "Enter must be valid phoneNumber !! ")
	private String phone;
	
	@NotEmpty
	@Size(min = 3, max = 20, message = "Password must be min of 3 chars and max of 20 chars !! ")
	//@Pattern(regexp = )
	private String password;
	
	//@NotEmpty
	private boolean status;
	
//	@Column(length = 500)
//	private String image;
	
	@NotEmpty
	private String gender;
	
	private String userStatus;
	
	private String personalAddress;
	
	
	
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


	public String getPersonalAddress() {
		return personalAddress;
	}


	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}
	

}
