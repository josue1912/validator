package com.example.validator.domain.regras;

import com.example.validator.core.Validador;
import com.example.validator.domain.validaveis.Produto;

import java.math.BigDecimal;
import java.util.Optional;

public class PrecoDeveSerValorPositivoValidador implements Validador<Produto> {

	@Override
	public boolean isValid(Produto produto) {
		System.out.println("Validando o preço do produto...");
		return Optional.ofNullable(produto)
				.map(Produto::preco)
				.filter(preco -> preco.compareTo(BigDecimal.ZERO) > 0)
				.isPresent();
	}

	@Override
	public boolean interrompeValidacao() {
		return true;
	}

	@Override
	public String getErro() {
		return "Preço do produto deve ser maior que zero";
	}
}
