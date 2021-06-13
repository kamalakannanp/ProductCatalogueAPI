package com.project.ProductCatalogueAPI.error;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductCatalogueExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ProductNotFoundException.class, ProductFoundException.class})
	public ResponseEntity<ProductErrorMessage> productNotFound(Exception ex) {
		
		ProductErrorMessage errorMessage =  new ProductErrorMessage();
		errorMessage.setError(ex.getMessage());
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		
		logger.info("error message "+ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		
	}

}
