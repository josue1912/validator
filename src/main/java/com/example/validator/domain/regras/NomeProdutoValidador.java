package com.example.validator.domain.regras;

import com.example.validator.core.Validador;
import com.example.validator.domain.validaveis.Produto;

import java.util.Optional;

public class NomeProdutoValidador implements Validador<Produto> {

	@Override
	public boolean isValid(Produto data) {
		System.out.println("Validando o nome do produto...");
		return Optional.ofNullable(data)
				.map(Produto::nome)
				.filter(nome -> nome.trim().length() > 3)
				.isPresent();
	}

	@Override
	public boolean interrompeValidacao() {
		return false;
	}

	@Override
	public String getErro() {
		return "Nome do produto deve ter mais que 3 letras";
	}
}
