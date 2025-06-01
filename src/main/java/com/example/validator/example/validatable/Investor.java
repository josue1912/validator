package com.example.validator.example.validatable;

import com.example.validator.core.Validatable;

public record Investor(String nome, String numeroConta) implements Validatable {

}
