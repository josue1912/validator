package com.example.validator.example.service;

import com.example.validator.core.ValidationError;
import com.example.validator.core.ValidationManager;
import com.example.validator.core.ValidationManagerFactory;
import com.example.validator.example.validatable.Product;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductService {

	public List<ValidationError> validatesProduct(Product product) {
		ValidationManager<Product> validadoresDeProduto = ValidationManagerFactory.getValidationManagerForType(Product.class);
		List<ValidationError> errosDeValidacao = validadoresDeProduto.validate(product);
		return errosDeValidacao;
	}
}
