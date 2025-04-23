create database vendas;

create table produto (
	id bigserial not null primary key,
	nome varchar(100) not null,
	descricao varchar(255),
	preco numeric(16, 2),
	sku varchar(20)	
)

alter table produto add column data_cadastro date;

CREATE TABLE cliente (

	id bigserial not null primary key,
	nascimento date NOT NULL,	
	nome varchar(100) NOT NULL,
	endereco varchar(255) NOT NULL,
	cpf varchar(14) NOT NULL,
	telefone varchar(14),
	email varchar(100),	
	data_cadastro date

)