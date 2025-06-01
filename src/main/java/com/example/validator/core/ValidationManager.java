package com.example.validator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que os gerenciadores de validação por tipo devem implementar
 */
public abstract class ValidationManager<Validatable> {

	private final List<Validador<Validatable>> validadors = new ArrayList<>();

	public List<ValidationError> validate(Validatable data) {
		List<ValidationError> errors = new ArrayList<>();
		for (Validador<Validatable> validador : validadors) {
			if (!validador.isValid(data)) {
				errors.add(validador.getValidationError());
				System.err.println("Erro ao validar [" + data.getClass().getSimpleName() + "] no validador [" + this.getClass().getSimpleName() + "." + validador.getClass().getSimpleName() + "]");
				if (validador.stopsValidation()) {
					System.err.println("O validador [" + validador.getClass().getSimpleName() + "] interrompeu o fluxo de validação");
					return errors;
				}
			}
		}
		return errors;
	}

	public void addValidator(Validador<Validatable> validador) {
		this.validadors.add(validador);
	}

}
