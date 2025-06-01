package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;
import br.com.validator.core.Validator;
import br.com.validator.example.validatable.Investor;

import java.util.Optional;

public class InvestorNameValidator implements Validator<Investor> {

	@Override
	public boolean isValid(Investor data) {
		System.out.println("Validando o nome do investidor...");
		return Optional.ofNullable(data)
				.map(Investor::name)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return false;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERROR_0001;
	}
}
