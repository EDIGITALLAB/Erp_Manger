package com.example.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.payloads.ApiResponse;
import com.example.erp.payloads.CategoryDto;
import com.example.erp.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create 
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto createCatogory = this.categoryService.createCatogory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createCatogory, HttpStatus.CREATED);
		
	}
	// update 
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto>  updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
		
		CategoryDto updateCatogory = this.categoryService.updateCatogory(categoryDto, catId);
		
		return new ResponseEntity<CategoryDto>(updateCatogory, HttpStatus.OK);
		
	}
	
	// delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		
		this.categoryService.deleteCategory(catId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is Deleted successfully..!!", true),HttpStatus.OK);
	}
	
	//get categoryById
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId){
		
		CategoryDto categoryById = this.categoryService.getCategoryById(catId);
		
		return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
		
	}
	
	//get all
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
		List<CategoryDto> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
		
	}

}
