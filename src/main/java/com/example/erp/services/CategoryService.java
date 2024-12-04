package com.example.erp.services;

import java.util.List;

import com.example.erp.payloads.CategoryDto;


public interface CategoryService {
	
	//create
	 CategoryDto createCatogory(CategoryDto categoryDto);
	
	// update
	 CategoryDto updateCatogory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	 void deleteCategory(Integer categoryId);
	
	//get 
	 CategoryDto getCategoryById(Integer categoryId);
	
	//get All
	 List<CategoryDto> getCategories();
	
	

}
