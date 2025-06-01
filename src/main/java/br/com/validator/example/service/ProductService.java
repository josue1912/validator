package br.com.validator.example.service;

import br.com.validator.core.ValidationError;
import br.com.validator.core.ValidationManager;
import br.com.validator.core.ValidationManagerFactory;
import br.com.validator.example.validatable.Product;

import java.util.List;

public class ProductService {

	public List<ValidationError> validatesProduct(Product product) {
		ValidationManager<Product> productValidators = ValidationManagerFactory.getValidationManagerForType(Product.class);
		List<ValidationError> validationErrors = productValidators.validate(product);
		return validationErrors;
	}
}
