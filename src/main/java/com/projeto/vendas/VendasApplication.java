package com.projeto.vendas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.domain.Vendedor;
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

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vendedor vend = new Vendedor(null, "Carlos");
		Produtos prod1 = new Produtos(null, "Mouse", BigDecimal.valueOf(100));
		Produtos prod2 = new Produtos(null, "teclado", BigDecimal.valueOf(200));
		Venda venda = new Venda(null, LocalDateTime.now(), vend);
		
		venda.getProduto().addAll(Arrays.asList(prod1, prod2));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
		vendedorRepository.save(vend);
		vendaRepository.save(venda);
		
		
		
	}

}
