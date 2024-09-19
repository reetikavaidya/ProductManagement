package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	 private ProductRepository repository;
//	post create new products
	public Product postproduct(Product products) {
		return repository.save(products);
	}
//get all products
	public Page<Product> getAllProducts(Pageable pageable){
		return repository.findAll(pageable);
	}
	//get all products by id
	public Product getProductsById(Long id) {
		return repository.findById(id).orElseThrow();
	}
	
//	Put-Update products by id
	public Product updateproducts(Long id, Product details) {
		Product products=getProductsById(id);
		products.setPname(details.getPname());
		products.setPprice(details.getPprice());
		products.setCategory(details.getCategory());
		return repository.save(products);
	}
//	Delete Product by id
	public void deleteProducts(Long id) {
		Product products=getProductsById(id);
		repository.delete(products);
	}
}
