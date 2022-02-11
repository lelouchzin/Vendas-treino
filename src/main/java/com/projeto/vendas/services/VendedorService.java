package com.projeto.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.Vendedor;
import com.projeto.vendas.repositories.VendedorRepository;
import com.projeto.vendas.services.exceptions.ObjectNotFoundException;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repo;

	public Vendedor find(Integer id) {
		Optional<Vendedor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Vendedor.class.getName()));

	}
	
	public Vendedor insert(Vendedor obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public List<Vendedor> findAll() {
		return repo.findAll();
	}
	
	
	
	
	
	
	

	
}
