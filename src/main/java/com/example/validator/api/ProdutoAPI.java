package com.example.validator.api;

import com.example.validator.core.ValidationManagerFactory;
import com.example.validator.domain.validaveis.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoAPI {

	@PostMapping
	public ResponseEntity<?> criaProduto(@RequestBody Produto produto) throws URISyntaxException {
		List<String> erros = ValidationManagerFactory.getManagerForType(Produto.class).validate(produto);
		if (erros.isEmpty()){
			return ResponseEntity.created(new URI("/url_exemplo")).body(produto);
		}
		return ResponseEntity.badRequest().body(erros);
	}
}
