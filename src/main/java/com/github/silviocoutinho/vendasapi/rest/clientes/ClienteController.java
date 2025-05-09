package com.github.silviocoutinho.vendasapi.rest.clientes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.silviocoutinho.vendasapi.model.Cliente;
import com.github.silviocoutinho.vendasapi.model.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody ClienteFormRequest request) {
		Cliente cliente = request.toModel();
		repository.save(cliente);
		return ResponseEntity.ok(ClienteFormRequest.fromModel(cliente));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@PathVariable Long id,
			@RequestBody ClienteFormRequest request	) {
		
		Optional<Cliente> existeRegistro = repository.findById(id);
		if(existeRegistro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente cliente = request.toModel();
		cliente.setId(id);
		repository.save(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteFormRequest> getById(@PathVariable Long id){
		return repository.findById(id)
				.map( ClienteFormRequest::fromModel)
				.map( clienteFR -> ResponseEntity.ok(clienteFR))
				.orElseGet( () ->  ResponseEntity.notFound().build() );
				
				//Pode ser orElse
				//. orElse( ResponseEntity.notFound().build() );
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		return repository.findById(id)
				.map( cliente -> {
					repository.delete(cliente);
					return ResponseEntity.noContent().build();
				})			
				.orElseGet( () ->  ResponseEntity.notFound().build() );
	}
	
	public List<ClienteFormRequest> getLista(){
		return repository
				.findAll()
				.stream()
				.map( ClienteFormRequest::fromModel )
				.collect(Collectors.toList());
				
	}
	
	

}
