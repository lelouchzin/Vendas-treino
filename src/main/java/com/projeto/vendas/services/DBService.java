package com.projeto.vendas.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.domain.Vendedor;
import com.projeto.vendas.repositories.ItensVendaRepository;
import com.projeto.vendas.repositories.ProdutosRepository;
import com.projeto.vendas.repositories.VendaRepository;
import com.projeto.vendas.repositories.VendedorRepository;

@Service
public class DBService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private VendedorRepository vendedorRepository;

	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired 
	private ItensVendaRepository itensVendaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Vendedor vend = new Vendedor(null, "Carlos");
		Vendedor vend2 = new Vendedor(null, "Roberta");
		Vendedor vend3 = new Vendedor(null, "Julio");

		Produtos prod1 = new Produtos(null, "Mouse", BigDecimal.valueOf(100));
		Produtos prod2 = new Produtos(null, "teclado", BigDecimal.valueOf(200));
		Produtos prod3 = new Produtos(null, "Mesa", BigDecimal.valueOf(500));
		Produtos prod4 = new Produtos(null, "Notebook", BigDecimal.valueOf(2050));

		Venda venda = new Venda(null, LocalDateTime.now(), vend);
		Venda venda2 = new Venda(null, LocalDateTime.now().plusDays(5), vend2);
		Venda venda3 = new Venda(null, LocalDateTime.now().plusMonths(2), vend3);

		ItensVenda iv1 = new ItensVenda(BigDecimal.valueOf(0), 2, prod1.getValorProduto(), prod1, venda);
		ItensVenda iv2 = new ItensVenda(BigDecimal.valueOf(0), 4, prod2.getValorProduto(), prod2, venda);
		ItensVenda iv3 = new ItensVenda(BigDecimal.valueOf(10), 3, prod3.getValorProduto(), prod3, venda2);
		ItensVenda iv4 = new ItensVenda(BigDecimal.valueOf(20), 1, prod4.getValorProduto(), prod4, venda3);

		venda.getProduto().addAll(Arrays.asList(prod1, prod2));
		venda2.getProduto().add(prod3);
		venda3.getProduto().addAll(Arrays.asList(prod4, prod3, prod2));

		prod1.getItens().addAll(Arrays.asList(iv1));
		prod2.getItens().addAll(Arrays.asList(iv2));
		prod3.getItens().add(iv3);
		prod4.getItens().add(iv4);

		venda.getItensVenda().addAll(Arrays.asList(iv1));
		venda.getItensVenda().addAll(Arrays.asList(iv2));
		venda2.getItensVenda().addAll(Arrays.asList(iv3));
		venda3.getItensVenda().add(iv4);
		
		vendedorRepository.saveAll(Arrays.asList(vend, vend2, vend3));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
		vendaRepository.saveAll(Arrays.asList(venda, venda2, venda3));
		itensVendaRepository.saveAll(Arrays.asList(iv1, iv2, iv3, iv4));
		
	}
	
}
