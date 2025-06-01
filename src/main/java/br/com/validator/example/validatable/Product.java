package br.com.validator.example.validatable;

import br.com.validator.core.Validatable;

import java.math.BigDecimal;

public record Product(String name, BigDecimal price) implements Validatable {

}
