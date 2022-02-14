package com.projeto.vendas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.dto.ProdutosDTO;
import com.projeto.vendas.dto.VendaNewDTO;
import com.projeto.vendas.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo;


	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName(), null));
	}

//	@Transactional
//	public Venda insert(VendaNewDTO obj) {
//		obj.getMomentoVenda();
//		Venda vend = new Venda(null, LocalDateTime.now(), obj.getVendedor());
//		repo.save(vend);
//		for(Produtos pro : obj.getProduto()) {
//			ProdutosDTO produto = new ProdutosDTO(pro);
//			produto.setVendas(vend);
//			produtosRepository.saveAll(produto);
//		}
//		return vend;
//	}

	public List<Venda> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}


}
