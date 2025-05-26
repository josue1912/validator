package com.example.validator.domain.validadores;

import com.example.validator.core.Validador;
import com.example.validator.core.ValidationManager;
import com.example.validator.domain.regras.NomeProdutoValidador;
import com.example.validator.domain.regras.PrecoDeveSerValorPositivoValidador;
import com.example.validator.domain.validaveis.Produto;

public class ProdutoValidationManager extends ValidationManager<Produto> {

	public ProdutoValidationManager(){
		super();
		super.addValidator(new NomeProdutoValidador());
		super.addValidator(new PrecoDeveSerValorPositivoValidador());
	}

	public void addValidator(Validador<Produto> validador) {
		super.addValidator(validador);
	}

}
