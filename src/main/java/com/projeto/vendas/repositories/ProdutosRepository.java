package com.projeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.vendas.domain.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

	
	
}
