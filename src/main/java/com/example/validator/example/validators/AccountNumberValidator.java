package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.core.Validador;
import com.example.validator.example.validatable.Investor;

import java.util.Optional;

public class AccountNumberValidator implements Validador<Investor> {

	@Override
	public boolean isValid(Investor data) {
		System.out.println("Validando numero da conta do investidor...");
		return Optional.ofNullable(data)
				.map(Investor::numeroConta)
				.filter(numeroConta -> numeroConta.length() == 10)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return true;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERRO_0003;
	}

}
