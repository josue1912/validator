package com.example.validator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que os gerenciadores de validação por tipo devem implementar
 */
public abstract class ValidationManager<Validavel> {

	private final List<Validador<Validavel>> validadors = new ArrayList<>();

	public List<String> validate(Validavel data) {
		List<String> errors = new ArrayList<>();
		for(Validador<Validavel> validador : validadors){
			if (!validador.isValid(data)){
				errors.add(validador.getErro());
				if (validador.interrompeValidacao()) {
					System.err.println("["+this.getClass().getSimpleName()+"] Interrompendo validacao no validador "+ validador.getClass().getSimpleName());
					return errors;
				}
			}
		}
		return errors;
	}

	public void addValidator(Validador<Validavel> validador) {
		this.validadors.add(validador);
	}

}
