package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;
import br.com.validator.core.Validator;
import br.com.validator.example.validatable.Product;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductPriceMustBePositiveValidator implements Validator<Product> {

	@Override
	public boolean isValid(Product product) {
		System.out.println("Validando o preço do produto...");
		return Optional.ofNullable(product)
				.map(Product::price)
				.filter(preco -> preco.compareTo(BigDecimal.ZERO) > 0)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return true;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERROR_0004;
	}
}
