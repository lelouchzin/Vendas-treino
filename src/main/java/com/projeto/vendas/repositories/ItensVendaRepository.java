package com.projeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.vendas.domain.ItensVenda;

@Repository
public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer>{

	
	
}
