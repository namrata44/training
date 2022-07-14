package com.cg.product.service;

import java.util.List;

import com.cg.product.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product getById(int id);
	public void deleteProduct(int productId);

}
