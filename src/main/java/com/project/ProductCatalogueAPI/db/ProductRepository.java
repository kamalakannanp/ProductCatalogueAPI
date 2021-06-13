package com.project.ProductCatalogueAPI.db;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ProductCatalogueAPI.Model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByBrand(String brand);

}
