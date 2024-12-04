package com.example.erp.payloads;

import java.util.Date;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String work;
	
	private String address;
	
	private String imageName;
	
	private Date joinDate;
	
	
	private CategoryDto category;
	
	private UserDto user;
	

}
