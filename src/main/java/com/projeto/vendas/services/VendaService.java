package com.projeto.vendas.services;

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
	private ProdutosRepository produtosRepository;

	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName(), null));
	}

//	public Venda insert(Venda obj) {
//		obj.setId(null);
//		obj.getMomentoVenda();
//		LocalDateTime.now();
//		return repo.save(obj);
//	}

	public List<Venda> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

//	public Venda fromDTO(VendaNewDTO objDto) {
//		objDto.getMomentoVenda();
//		Venda venda = new Venda(null, LocalDateTime.now(), objDto.getVendedor());
//		for (Produtos pro : objDto.getProduto()) {
//			pro.setVendas(venda);
//			produtosRepository.save(pro);
//		}
//		return venda;
//	}

}
