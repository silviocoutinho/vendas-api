package com.github.silviocoutinho.vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.silviocoutinho.vendasapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
