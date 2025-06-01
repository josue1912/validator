package com.example.validator.example.validators;

import com.example.validator.core.ValidationError;
import com.example.validator.example.validatable.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberValidatorTest {

	private AccountNumberValidator validator;

	@BeforeEach
	public void config(){
		validator = new AccountNumberValidator();
	}

	@Test
	void shouldReturnValidWhenAccountNumberHas10Digits(){
		Investor investor = new Investor("Jon Snow", "1020304050");
		boolean result = validator.isValid(investor);
		assertTrue(result);
	}

	@Test
	void shouldReturnInalidWhenAccountNumberHasLessThan10Digits(){
		Investor investor = new Investor("Jon Snow", "102030405");
		boolean result = validator.isValid(investor);
		assertFalse(result);
	}

	@Test
	void shouldReturnInalidWhenAccountNumberHasMoreThan10Digits(){
		Investor investor = new Investor("Jon Snow", "10203040506");
		boolean result = validator.isValid(investor);
		assertFalse(result);
	}

	@Test
	void shouldReturnAppropriateEnum(){
		ValidationError error = validator.getValidationError();
		assertEquals(CustomError.ERRO_0003, error);
	}

	@Test
	void shouldInterruptValidation(){
		boolean stopsValidation = validator.stopsValidation();
		assertTrue(stopsValidation);
	}

	@Test
	void shouldReturnInvalidWhenNameInvestorIsNull(){
		boolean result = validator.isValid(new Investor("Jon Snow", null));
		assertFalse(result);
	}

}