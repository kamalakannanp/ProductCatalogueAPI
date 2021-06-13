package com.project.ProductCatalogueAPI.error;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
