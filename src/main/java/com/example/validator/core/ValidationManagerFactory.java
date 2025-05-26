package com.example.validator.core;

import com.example.validator.domain.validadores.ProdutoValidationManager;
import com.example.validator.domain.validaveis.Produto;
import com.example.validator.domain.validaveis.Investidor;
import com.example.validator.domain.validadores.InvestidorValidationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica o gerenciador de validadores de um tipo específico
 */
public class ValidationManagerFactory {

	// Mapa para armazenar instâncias de gerenciadores
	private static final Map<Class<?>, ValidationManager<?>> managers = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <Validavel> ValidationManager<Validavel> getManagerForType(Class<Validavel> type) {
		// Cria e registra um novo gerenciador se não existir para este tipo
		if (!managers.containsKey(type)) {
			if (type == Investidor.class) {
				managers.put(Investidor.class, new InvestidorValidationManager());
			} else if (type == Produto.class) {
				managers.put(type, new ProdutoValidationManager());
			} else {
				// Para outros tipos, você pode ter um gerenciador genérico ou lançar uma exceção se o tipo não for suportado
				throw new IllegalArgumentException("Nenhum gerenciador de validação configurado para o tipo: " + type.getName());
			}
		}
		return (ValidationManager<Validavel>) managers.get(type);
	}

	// Método para resetar a fábrica (útil para testes, etc.)
	public static void resetFactory() {
		managers.clear();
	}
}
