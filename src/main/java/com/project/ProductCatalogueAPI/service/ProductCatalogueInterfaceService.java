package com.project.ProductCatalogueAPI.service;

import java.util.List;

import com.project.ProductCatalogueAPI.Model.Product;

public interface ProductCatalogueInterfaceService {

	public List<Product> getProductList();
	public List<Product> getProductByBrand(List<Product> filterProduct, String brandType);
}
