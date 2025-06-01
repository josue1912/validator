package com.example.validator.example.validation_manager;

import com.example.validator.core.ValidationManager;
import com.example.validator.core.Validador;
import com.example.validator.example.validators.InvestorNameValidator;
import com.example.validator.example.validators.AccountNumberValidator;
import com.example.validator.example.validatable.Investor;

public class InvestorValidationManager extends ValidationManager<Investor> {

	public InvestorValidationManager() {
		super();
		addValidator(new AccountNumberValidator());
		addValidator(new InvestorNameValidator());
	}

	public void addValidator(Validador<Investor> validador) {
		super.addValidator(validador);
	}

}
