package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;

public enum CustomError implements ValidationError {

	ERROR_0001("Nome do investidor deve ter mais que 3 letras"),
	ERROR_0002("Nome do produto deve ter mais que 3 letras"),
	ERROR_0003("Conta do investidor deve ter 10 dígitos"),
	ERROR_0004("Preço do produto deve ser maior que zero")
	;

	private final String description;

	CustomError(String description) {
		this.description = description;
	}

}
