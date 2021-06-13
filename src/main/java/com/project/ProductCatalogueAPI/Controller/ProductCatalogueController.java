package com.project.ProductCatalogueAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ProductCatalogueAPI.Model.Product;
import com.project.ProductCatalogueAPI.error.ProductNotFoundException;
import com.project.ProductCatalogueAPI.service.ProductCatalogueInterfaceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ProductCatalogue")
public class ProductCatalogueController {
	
	@Autowired
	private ProductCatalogueInterfaceService productCatalogueService;

	@GetMapping("/getProductList")
	public List<Product> getProductList() {
		
		List<Product> productList = productCatalogueService.getProductList();
		if (productList == null) {
			throw new ProductNotFoundException("Product Not Found");
		} 
		return productList;
	}
	
	@PostMapping("/filterByBrand/{BrandType}")
	public List<Product> getProductByBrand(@RequestBody Optional<List<Product>> product, @PathVariable("BrandType") String brandType) {
		
		System.out.println("brand type {}"+brandType);
		
		System.out.println("product "+product);
		List<Product> filterProduct = null;
		if (product.isPresent()) {
			System.out.println("value is present");
			filterProduct = product.get();
		} else {
			System.out.println(" null ");
		}
		
		List<Product> productListByBrand = productCatalogueService.getProductByBrand(filterProduct, brandType);
		
		return productListByBrand;
	}
	
	
	
}
