package com.example.validator.core;

/**
 * Interface que as regras devem implementar para serem validadas no fluxo de validação
 *
 * @param <Validavel>
 */
public interface Validador<Validavel> {

	boolean isValid(Validavel data);

	boolean interrompeValidacao();

	String getErro();
}
