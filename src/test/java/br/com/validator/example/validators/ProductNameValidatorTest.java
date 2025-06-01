package br.com.validator.example.validators;

import br.com.validator.core.ValidationError;
import br.com.validator.example.validatable.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductNameValidatorTest {

	private ProductNameValidator validator;

	@BeforeEach
	public void config(){
		this.validator = new ProductNameValidator();
	}

	@Test
	void shouldReturnValidWhenNameHasMoreThan3Characters() {
		Product product = new Product("Keyboard", new BigDecimal("10.99"));
		boolean result = validator.isValid(product);
		assertTrue(result);
	}

	@Test
	void shouldReturnInvalidWhenNameHasLessThan3Characters() {
		Product product = new Product("Ke", new BigDecimal("10.99"));
		boolean result = validator.isValid(product);
		assertFalse(result);
	}

	@Test
	void shouldReturnInvalidWhenNameHas3Characters() {
		Product product = new Product("Key", new BigDecimal("10.99"));
		boolean result = validator.isValid(product);
		assertFalse(result);
	}

	@Test
	void shouldReturnAppropriateEnum(){
		ValidationError error = validator.getValidationError();
		assertEquals(CustomError.ERROR_0002, error);
	}

	@Test
	void shouldNotInterruptValidation(){
		boolean stopsValidation = validator.stopsValidation();
		assertFalse(stopsValidation);
	}

	@Test
	void shouldReturnInvalidWhenNameInvestorIsNull(){
		boolean result = validator.isValid(new Product(null, new BigDecimal("10.99")));
		assertFalse(result);
	}
}