package com.cg.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.exception.ProductNotFoundException;
import com.cg.product.model.Product;
import com.cg.product.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {

		Product newProduct = productRepository.save(product);
		return newProduct;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> newProduct = productRepository.findById(product.getProductId());
		Product Product1 = productRepository.save(product);

		return Product1;
	}

	@Override
	public Product getById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> productById = productRepository.findById(id);

		if (productById.isEmpty()) {
			throw new ProductNotFoundException(" product not found with id : " + id);
		}
		Product product = productById.get();
		return product;

	}

	@Override
	public void deleteProduct(int producttId) {
	
		Optional<Product> optionalProduct = productRepository.findById(producttId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not found with id: "+producttId);
		}
		
		productRepository.deleteById(producttId);		
	}

}