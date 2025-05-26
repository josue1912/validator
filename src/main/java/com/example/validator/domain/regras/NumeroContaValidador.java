package com.example.validator.domain.regras;

import com.example.validator.core.Validador;
import com.example.validator.domain.validaveis.Investidor;

import java.util.Optional;

public class NumeroContaValidador implements Validador<Investidor> {

	@Override
	public boolean isValid(Investidor data) {
		System.out.println("Validando numero da conta do investidor...");
		return Optional.ofNullable(data)
				.map(Investidor::numeroConta)
				.filter(numeroConta -> numeroConta.length() == 10)
				.isPresent();
	}

	@Override
	public boolean interrompeValidacao() {
		return true;
	}

	@Override
	public String getErro() {
		return "Conta do investidor deve ter 10 dígitos";
	}



}
