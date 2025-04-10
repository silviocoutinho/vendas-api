package com.github.silviocoutinho.vendasapi.rest.produtos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.silviocoutinho.vendasapi.model.Produto;
import com.github.silviocoutinho.vendasapi.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto) {
		
		Produto entidadeProduto = produto.toModel();		
		repository.save(entidadeProduto);		
		return ProdutoFormRequest.fromModel(entidadeProduto);
	}
	
	//api/produtos/id
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto) {
		
		Optional<Produto> produtoExistente = repository.findById(id);
		if (produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Produto entidadeProduto = produto.toModel();		
		entidadeProduto.setId(id);
		repository.save(entidadeProduto);
		
		return ResponseEntity.ok().build();
		
	}
	

}
