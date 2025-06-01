package com.example.validator.core;

/**
 * Contrato que os validadores devem implementar para serem validados no fluxo de validação
 *
 * @param <Validatable>
 */
public interface Validador<Validatable> {

	boolean isValid(Validatable data);

	boolean stopsValidation();

	ValidationError getValidationError();
}
