package com.projeto.vendas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.repositories.VendaRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{
	
	@Autowired
	private VendaRepository vendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		Venda venda = new Venda(1, BigDecimal.valueOf(1200), LocalDateTime.now());
		
		
		vendaRepository.save(venda);
		
		
		
	}

}
