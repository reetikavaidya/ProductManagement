package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@PostMapping
	public Category postCategory(@RequestBody Category categories) {
		return service.postCategory(categories);
	}
	
//	{
//    "name": "Shoes"
//}
	
   @GetMapping
   public Page<Category> getAllCategories(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size){
	  Pageable pageable=PageRequest.of(page, size);
	   return service.getAllCategories(pageable);
   }
   
   @GetMapping("/{id}")
   public Category getCategoryById(@PathVariable Long id) {
	   return service.getCategoryById(id);
   }
   
   @PutMapping("/{id}")
   public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
       return service.updateCategory(id, category);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
      service.deleteCategory(id);
       return ResponseEntity.ok().build();
   }
}
