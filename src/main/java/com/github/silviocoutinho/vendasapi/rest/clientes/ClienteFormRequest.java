package com.github.silviocoutinho.vendasapi.rest.clientes;

import java.time.LocalDate;

import com.github.silviocoutinho.vendasapi.model.Cliente;

public class ClienteFormRequest {
	
	private Long id;
	private LocalDate nascimento;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private LocalDate cadastro;
		
	public ClienteFormRequest() {
		super();
	}
	
	public ClienteFormRequest(Long id, LocalDate nascimento, String cpf, String nome, String endereco, String telefone,
			String email, LocalDate cadastro) {
		super();
		this.id = id;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.cadastro = cadastro;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCadastro() {
		return cadastro;
	}
	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}
	
	public Cliente toModel() {
		return new Cliente(id, nascimento, cpf, nome, endereco, telefone, email, cadastro);
	}	
	public static ClienteFormRequest fromModel(Cliente cliente) {
		return new ClienteFormRequest(cliente.getId(), cliente.getNascimento(), 
				cliente.getCpf(), cliente.getNome(), cliente.getEndereco(),
				cliente.getEmail(), cliente.getTelefone(), cliente.getDataCadastro());
				
	}	

}
