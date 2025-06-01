package br.com.validator.example.validation_manager;

import br.com.validator.core.ValidationManager;
import br.com.validator.core.Validator;
import br.com.validator.example.validators.InvestorNameValidator;
import br.com.validator.example.validators.AccountNumberValidator;
import br.com.validator.example.validatable.Investor;

public class InvestorValidationManager extends ValidationManager<Investor> {

	public InvestorValidationManager() {
		super();
		addValidator(new AccountNumberValidator());
		addValidator(new InvestorNameValidator());
	}

	public void addValidator(Validator<Investor> validator) {
		super.addValidator(validator);
	}

}
