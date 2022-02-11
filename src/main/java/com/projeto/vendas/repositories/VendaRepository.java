package com.projeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.vendas.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

	
	
}
