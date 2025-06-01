package br.com.validator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que os gerenciadores de validação por tipo devem implementar
 */
public abstract class ValidationManager<Validatable> {

	private final List<Validator<Validatable>> validators = new ArrayList<>();

	public List<ValidationError> validate(Validatable data) {
		List<ValidationError> errors = new ArrayList<>();
		for (Validator<Validatable> validator : validators) {
			if (!validator.isValid(data)) {
				errors.add(validator.getValidationError());
				System.err.println("Erro ao validar [" + data.getClass().getSimpleName() + "] no validador [" + this.getClass().getSimpleName() + "." + validator.getClass().getSimpleName() + "]");
				if (validator.stopsValidation()) {
					System.err.println("O validador [" + validator.getClass().getSimpleName() + "] interrompeu o fluxo de validação com o erro [" + validator.getValidationError() + "]");
					return errors;
				}
			}
		}
		return errors;
	}

	public void addValidator(Validator<Validatable> validator) {
		this.validators.add(validator);
	}

}
