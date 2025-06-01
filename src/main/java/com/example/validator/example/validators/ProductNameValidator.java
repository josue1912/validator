package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.core.Validador;
import com.example.validator.example.validatable.Product;

import java.util.Optional;

public class ProductNameValidator implements Validador<Product> {

	@Override
	public boolean isValid(Product data) {
		System.out.println("Validando o nome do produto...");
		return Optional.ofNullable(data)
				.map(Product::nome)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return false;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERRO_0002;
	}
}
