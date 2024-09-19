package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
//	POST - create a new category
	public Category postCategory(Category categories) {
		return repository.save(categories);
	}
//	GET all the categories
     public Page<Category> getAllCategories(Pageable pageable){
    	 return repository.findAll(pageable);
     }
//     GET category by Id
     public Category getCategoryById(Long id) {
         return repository.findById(id).orElseThrow();
     }
     
//   Put-  Update category by id
     public Category updateCategory(Long id,Category details) {
    	 Category category=getCategoryById(id);
    	 category.setName(details.getName());
    	 return repository.save(category);
     }
     
     //Delete category by id
     public void deleteCategory(Long id) {
    	 Category category=getCategoryById(id);
    	 repository.delete(category);
     }
}
