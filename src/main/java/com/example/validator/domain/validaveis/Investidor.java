package com.example.validator.domain.validaveis;

import com.example.validator.core.Validavel;

public record Investidor(String nome, String numeroConta) implements Validavel {

}
