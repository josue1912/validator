package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;
import br.com.validator.core.Validator;
import br.com.validator.example.validatable.Product;

import java.util.Optional;

public class ProductNameValidator implements Validator<Product> {

	@Override
	public boolean isValid(Product data) {
		System.out.println("Validando o nome do produto...");
		return Optional.ofNullable(data)
				.map(Product::name)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return false;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERROR_0002;
	}
}
