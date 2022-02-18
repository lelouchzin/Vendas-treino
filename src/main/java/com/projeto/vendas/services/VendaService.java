package com.projeto.vendas.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.domain.Vendedor;
import com.projeto.vendas.dto.VendaNewDTO;
import com.projeto.vendas.repositories.ItensVendaRepository;
import com.projeto.vendas.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo;

	@Autowired
	private ItensVendaRepository itensVendaRepository;

	@Autowired
	private ProdutoService produtoService;

	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Venda.class.getName(), null));
	}

	@Transactional
	public Venda insert(VendaNewDTO obj) {
		Vendedor vende = new Vendedor(obj.getVendedorid(), null);
		obj.getMomentoVenda();
		Venda venda = new Venda(null, LocalDateTime.now(), vende);
		repo.save(venda);
		for (ItensVenda iv : obj.getItensVenda()) {
			iv.setDesconto(iv.getDesconto());
			iv.setProduto(produtoService.find(iv.getProduto().getId()));
			iv.setPreco(iv.getProduto().getValorProduto());
			iv.setVenda(venda);
		}
		itensVendaRepository.saveAll(obj.getItensVenda());
		return venda;
	}

	public List<Venda> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

}
