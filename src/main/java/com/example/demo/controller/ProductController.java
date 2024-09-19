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

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public Product postProduct(@RequestBody Product product) {
		return service.postproduct(product);
//		{
//		    "pname": "addidas",
//		    "pprice":"1600",
//		    "category":{
//		        "id":1
//		    }
//		   
//		}
		
	}
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10")int size){
		Pageable pageable=PageRequest.of(page, size);
		return service.getAllProducts(pageable);
	}
	@GetMapping("/{id}")
	public Product getproductById(@PathVariable Long id) {
		return service.getProductsById(id);
	}
	@PutMapping("/{id}")
	public Product Updateproduct(@PathVariable Long id,@RequestBody Product products) {
		return service.updateproducts(id, products);
	}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteproducts(@PathVariable Long id){
	service.deleteProducts(id);
	return ResponseEntity.ok().build();
}
}
