package com.example.validator.domain.validaveis;

import com.example.validator.core.Validavel;

import java.math.BigDecimal;

public record Produto(String nome, BigDecimal preco) implements Validavel {

}
