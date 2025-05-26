package com.example.validator;

import com.example.validator.core.ValidationManagerFactory;
import com.example.validator.domain.validadores.ProdutoValidationManager;
import com.example.validator.domain.validaveis.Produto;
import com.example.validator.domain.validaveis.Investidor;

import java.math.BigDecimal;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//Exemplo utilizando ValidationManager pelo tipo do validavel
		Produto produto = new Produto("Note", new BigDecimal("-4500.87"));
		List<String> errosProduto = new ProdutoValidationManager()
				.validate(produto);
		System.out.println("Erros encontrados na validação do produto: " + errosProduto.toString());


		//Exemplo utilizando factory para instanciar o ValidationManager para o tipo de validavel
		Investidor investidor = new Investidor("Luiz Barsi", "123456789");
		List<String> errosInvestidor = ValidationManagerFactory
				.getManagerForType(Investidor.class)
				.validate(investidor);
		System.out.println("Erros encontrados na validalidação do investidor: " + errosInvestidor.toString());

	}
}
