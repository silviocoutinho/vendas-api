package com.github.silviocoutinho.vendasapi.rest.produtos;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.silviocoutinho.vendasapi.model.Produto;
import com.github.silviocoutinho.vendasapi.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public List<ProdutoFormRequest> getLista(){
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return repository.findAll().stream().map(new Function<Produto, ProdutoFormRequest>() {

			@Override
			public ProdutoFormRequest apply(Produto t) {
				// TODO Auto-generated method stub
				return ProdutoFormRequest.fromModel(t);
			}
		
		}).collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProdutoFormRequest> getById( @PathVariable Long id) {
		Optional<Produto> produtoExistente = repository.findById(id);
		if(produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		ProdutoFormRequest produto = produtoExistente.map(ProdutoFormRequest::fromModel).get();
		return ResponseEntity.ok(produto);
		
	}
	
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
