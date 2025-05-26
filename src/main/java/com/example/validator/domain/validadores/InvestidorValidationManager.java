package com.example.validator.domain.validadores;

import com.example.validator.core.ValidationManager;
import com.example.validator.core.Validador;
import com.example.validator.domain.regras.NomeInvestidorValidador;
import com.example.validator.domain.regras.NumeroContaValidador;
import com.example.validator.domain.validaveis.Investidor;

public class InvestidorValidationManager extends ValidationManager<Investidor> {

	public InvestidorValidationManager(){
		super();
		super.addValidator(new NumeroContaValidador());
		super.addValidator(new NomeInvestidorValidador());
	}

	public void addValidator(Validador<Investidor> validador) {
		super.addValidator(validador);
	}

}
