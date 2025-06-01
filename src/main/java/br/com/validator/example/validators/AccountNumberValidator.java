package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;
import br.com.validator.core.Validator;
import br.com.validator.example.validatable.Investor;

import java.util.Optional;

public class AccountNumberValidator implements Validator<Investor> {

	@Override
	public boolean isValid(Investor data) {
		System.out.println("Validando numero da conta do investidor...");
		return Optional.ofNullable(data)
				.map(Investor::accountNumber)
				.filter(numeroConta -> numeroConta.length() == 10)
				.isPresent();
	}

	@Override
	public boolean stopsValidation() {
		return true;
	}

	@Override
	public ValidationError getValidationError() {
		return CustomError.ERROR_0003;
	}

}
