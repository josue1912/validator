package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.example.validatable.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvestorNameValidadorTest {

	private InvestorNameValidator validator;

	@BeforeEach
	public void config(){
		this.validator = new InvestorNameValidator();
	}

	@Test
	void shouldReturnValidWhenNameHasMoreThan3Characters() {
		Investor investor = new Investor("João da Silva", "1020403040");
		boolean result = validator.isValid(investor);
		assertTrue(result);
	}

	@Test
	void shouldReturnInvalidWhenNameHasLessThan3Characters() {
		Investor investor = new Investor("Sr", "1020403040");
		boolean result = validator.isValid(investor);
		assertFalse(result);
	}

	@Test
	void shouldReturnInvalidWhenNameHas3Characters() {
		Investor investor = new Investor("Ana", "1020403040");
		boolean result = validator.isValid(investor);
		assertFalse(result);
	}

	@Test
	void shouldReturnAppropriateEnum(){
		ValidationError error = validator.getValidationError();
		assertEquals(CustomError.ERRO_0001, error);
	}

	@Test
	void shouldNotInterruptValidation(){
		boolean stopsValidation = validator.stopsValidation();
		assertFalse(stopsValidation);
	}

	@Test
	void shouldReturnInvalidWhenNameInvestorIsNull(){
		boolean result = validator.isValid(new Investor(null, "1020403040"));
		assertFalse(result);
	}
}