package com.cg.product.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.model.Product;
import com.cg.product.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/product/save")
	public Product addProduct(@RequestBody Product product) {


		return productService.saveProduct(product);
	}
	
	@PutMapping("/product/update")
	public Product updatedProductProfile(@RequestBody Product product) {
		
		return productService.updateProduct(product);
	}
	
	@GetMapping("/product/find/{productId}")
	public Product fetchProductById(@PathVariable("productId") int productId) {
		
		return productService.getById(productId);
	}
	
	@DeleteMapping("/product/delete/{productId}")
	public ResponseEntity<String> removeProduct(@PathVariable("productId") int productId) {
		
		productService.deleteProduct(productId);		
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
		return responseEntity;		
	}
}