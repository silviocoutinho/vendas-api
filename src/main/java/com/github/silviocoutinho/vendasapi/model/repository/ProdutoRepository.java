package com.github.silviocoutinho.vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.silviocoutinho.vendasapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
