package com.projeto.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.repositories.ProdutosRepository;
import com.projeto.vendas.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutosRepository repo;

	public Produtos find(Integer id) {
		Optional<Produtos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Produtos.class.getName()));

	}
	
	
	public Produtos insert(Produtos obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public List<Produtos> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		
	}
	
	
	
	
	
}
