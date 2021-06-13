package com.project.ProductCatalogueAPI.error;

public class ProductFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductFoundException(String message){
		super(message);
	}
}
