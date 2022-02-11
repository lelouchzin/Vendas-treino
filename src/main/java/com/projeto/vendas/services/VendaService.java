package com.projeto.vendas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.repositories.ProdutosRepository;
import com.projeto.vendas.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo;

	@Autowired
	private ProdutosRepository proRepo;

	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName(), null));
	}

	public Venda insert(Venda obj) {
		Venda novaVenda = new Venda(null, null, obj.getVendedor());
		obj.setMomentoCompra(LocalDateTime.now());
		obj.setVendedor(obj.getVendedor());
		repo.save(novaVenda);
		proRepo.saveAll(obj.getProduto());
		return obj;
	}

	
	
	
	
	
	
	
	
	
	
	
	public List<Venda> findAll() {
		return repo.findAll();
	}
	
	
}
