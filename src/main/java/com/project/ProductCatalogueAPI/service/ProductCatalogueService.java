package com.project.ProductCatalogueAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ProductCatalogueAPI.Model.Product;
import com.project.ProductCatalogueAPI.db.ProductRepository;

@Service
public class ProductCatalogueService implements ProductCatalogueInterfaceService {
	
	@Autowired
	private ProductRepository productRepository;
		
	public List<Product> getProductList() {	
		List<Product> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);		
		return productList;
	}
	
	public List<Product> getProductByBrand(List<Product> filterProduct, String brandType) {
		System.out.println("brandType "+brandType);		
		List<Product> productList = new ArrayList<>();
		
		if (filterProduct != null) {
			System.out.println("insode if (filterProduct != null)");
			productList = filterProduct.stream().filter(product -> brandType.contentEquals(product.getBrand())).collect(Collectors.toList());
			//forEach(productList::add);
		} else {
			productRepository.findByBrand(brandType).forEach(productList::add);
		}
		
		return productList;
	}
	
}

