package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.core.Validador;
import com.example.validator.example.validatable.Product;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductPriceMustBePositiveValidator implements Validador<Product> {

	@Override
	public boolean isValid(Product product) {
		System.out.println("Validando o preço do produto...");
		return Optional.ofNullable(product)
				.map(Product::preco)
				.filter(preco -> preco.compareTo(BigDecimal.ZERO) > 0)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return true;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERRO_0004;
	}
}
