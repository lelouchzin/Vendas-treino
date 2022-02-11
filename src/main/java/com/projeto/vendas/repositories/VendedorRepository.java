package com.projeto.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.vendas.domain.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{

	
	
}
