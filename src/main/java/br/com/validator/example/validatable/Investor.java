package br.com.validator.example.validatable;

import br.com.validator.core.Validatable;

public record Investor(String name, String accountNumber) implements Validatable {

}
