package com.cg.product.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
