package com.example.erp.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.erp.enttity.Category;
import com.example.erp.exception.ResourceNotFoundException;
import com.example.erp.payloads.CategoryDto;
import com.example.erp.repositoy.CategoryRepository;
import com.example.erp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

//create ----------------------->
	@Override
	public CategoryDto createCatogory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedcat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedcat, CategoryDto.class);
	}

//update ------------------------>
	@Override
	public CategoryDto updateCatogory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryTitel(categoryDto.getCategoryTitel());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		
		Category updatedcat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

//delete------------------------------->
	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
		
		this.categoryRepo.delete(cat);
		
	}

//get single -------------------------->
	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

//get All---------------------------------------->
	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
