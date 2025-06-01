package br.com.validator.core;

import br.com.validator.example.validatable.Investor;
import br.com.validator.example.validatable.Product;
import br.com.validator.example.validation_manager.InvestorValidationManager;
import br.com.validator.example.validation_manager.ProductValidationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica o gerenciador de validadores de um tipo específico
 */
public class ValidationManagerFactory {

	// Mapa para armazenar instâncias de gerenciadores
	private static final Map<Class<?>, ValidationManager<?>> managers = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <Validatable> ValidationManager<Validatable> getValidationManagerForType(Class<Validatable> type) {
		// Cria e registra um novo gerenciador se não existir para este tipo
		if (!managers.containsKey(type)) {
			if (type == Investor.class) {
				managers.put(Investor.class, new InvestorValidationManager());
			} else if (type == Product.class) {
				managers.put(type, new ProductValidationManager());
			} else {
				// Para outros tipos, você pode ter um gerenciador genérico ou lançar uma exception se o tipo não for suportado
				throw new IllegalArgumentException("Nenhum gerenciador de validação configurado para o tipo [" + type.getName() + "]");
			}
		}
		return (ValidationManager<Validatable>) managers.get(type);
	}

	// Metodo para resetar a fábrica (útil para testes, etc.)
	public static void resetFactory() {
		managers.clear();
	}
}
