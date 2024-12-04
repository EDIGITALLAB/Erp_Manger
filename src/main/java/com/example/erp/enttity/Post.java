package com.example.erp.enttity;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name ="post_work")
	private String work;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "image_name", length = 1000)
	private String imageName;
	
	@Column(name = "join_date")
	private Date joinDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;

}
