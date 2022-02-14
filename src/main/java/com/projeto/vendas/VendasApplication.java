package com.projeto.vendas;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.domain.Vendedor;
import com.projeto.vendas.repositories.ItensVendaRepository;
import com.projeto.vendas.repositories.ProdutosRepository;
import com.projeto.vendas.repositories.VendaRepository;
import com.projeto.vendas.repositories.VendedorRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired
	private ItensVendaRepository itensVendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vendedor vend = new Vendedor(null, "Carlos");
		Produtos prod1 = new Produtos(null, "Mouse", BigDecimal.valueOf(100));
		Produtos prod2 = new Produtos(null, "teclado", BigDecimal.valueOf(200));
		Venda venda = new Venda(null, LocalDateTime.now(), vend);
		
		
		ItensVenda iv1 = new ItensVenda(BigDecimal.valueOf(0), 2, BigDecimal.valueOf(100), prod1, venda);
		ItensVenda iv2 = new ItensVenda(BigDecimal.valueOf(0), 4, BigDecimal.valueOf(200), prod2, venda);
		
		venda.getItensVenda().addAll(Arrays.asList(iv1, iv2));
		
		prod1.getItens().addAll(Arrays.asList(iv1));
		prod2.getItens().addAll(Arrays.asList(iv2));
		
		
		venda.getProduto().addAll(Arrays.asList(prod1, prod2));
		
		vendedorRepository.saveAll(Arrays.asList(vend));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
		vendaRepository.saveAll(Arrays.asList(venda));
		itensVendaRepository.saveAll(Arrays.asList(iv1, iv2));
		
		
		
	}

}
