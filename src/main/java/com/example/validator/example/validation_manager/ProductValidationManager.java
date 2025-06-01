package com.example.validator.example.validation_manager;

import com.example.validator.core.Validador;
import com.example.validator.core.ValidationManager;
import com.example.validator.example.validators.ProductNameValidator;
import com.example.validator.example.validators.ProductPriceMustBePositiveValidator;
import com.example.validator.example.validatable.Product;

public class ProductValidationManager extends ValidationManager<Product> {

	public ProductValidationManager() {
		super();
		addValidator(new ProductNameValidator());
		addValidator(new ProductPriceMustBePositiveValidator());
	}

	public void addValidator(Validador<Product> validador) {
		super.addValidator(validador);
	}

}
