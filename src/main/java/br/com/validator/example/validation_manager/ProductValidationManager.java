package br.com.validator.example.validation_manager;

import br.com.validator.core.Validator;
import br.com.validator.core.ValidationManager;
import br.com.validator.example.validators.ProductNameValidator;
import br.com.validator.example.validators.ProductPriceMustBePositiveValidator;
import br.com.validator.example.validatable.Product;

public class ProductValidationManager extends ValidationManager<Product> {

	public ProductValidationManager() {
		super();
		addValidator(new ProductNameValidator());
		addValidator(new ProductPriceMustBePositiveValidator());
	}

	public void addValidator(Validator<Product> validator) {
		super.addValidator(validator);
	}

}
