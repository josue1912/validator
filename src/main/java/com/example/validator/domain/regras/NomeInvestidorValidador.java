package com.example.validator.domain.regras;

import com.example.validator.core.Validador;
import com.example.validator.domain.validaveis.Investidor;

import java.util.Optional;

public class NomeInvestidorValidador implements Validador<Investidor> {

	@Override
	public boolean isValid(Investidor data) {
		System.out.println("Validando o nome do investidor...");
		return Optional.ofNullable(data)
				.map(Investidor::nome)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean interrompeValidacao() {
		return false;
	}

	@Override
	public String getErro() {
		return "Nome do investidor deve ter mais que 3 letras";
	}
}
