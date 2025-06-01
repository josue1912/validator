package br.com.validator.example.service;

import br.com.validator.core.ValidationError;
import br.com.validator.example.validatable.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {

	private ProductService service;

	@BeforeEach
	public void config(){
		this.service = new ProductService();
	}

	@Test
	void shouldReturnValidWhenProductIsValid() {
		Product product = new Product("Keyboard", new BigDecimal("125.80"));
		List<ValidationError> retorno = service.validatesProduct(product);
		assertTrue(retorno.isEmpty());
	}

	@Test
	void shouldReturnInvalidWhenProductIsNotValid() {
		Product product = new Product("Key", new BigDecimal("-125.80"));
		List<ValidationError> retorno = service.validatesProduct(product);
		assertFalse(retorno.isEmpty());
	}

}