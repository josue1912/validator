package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.core.Validador;
import com.example.validator.example.validatable.Investor;

import java.util.Optional;

public class InvestorNameValidator implements Validador<Investor> {

	@Override
	public boolean isValid(Investor data) {
		System.out.println("Validando o nome do investidor...");
		return Optional.ofNullable(data)
				.map(Investor::nome)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return false;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERRO_0001;
	}
}
