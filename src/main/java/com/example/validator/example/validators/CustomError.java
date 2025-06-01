package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;

public enum CustomError implements ValidationError {

	ERRO_0001("Nome do investidor deve ter mais que 3 letras"),
	ERRO_0002("Nome do produto deve ter mais que 3 letras"),
	ERRO_0003("Conta do investidor deve ter 10 dígitos"),
	ERRO_0004("Preço do produto deve ser maior que zero")
	;

	private final String descricao;

	CustomError(String descricao) {
		this.descricao = descricao;
	}

}
