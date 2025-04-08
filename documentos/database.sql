create database vendas;

create table produto (
	id bigserial not null primary key,
	nome varchar(100) not null,
	descricao varchar(255),
	preco numeric(16, 2),
	sku varchar(20)	
)
