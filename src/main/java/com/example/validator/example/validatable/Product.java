package com.example.validator.example.validatable;

import com.example.validator.core.Validatable;

import java.math.BigDecimal;

public record Product(String nome, BigDecimal preco) implements Validatable {

}
