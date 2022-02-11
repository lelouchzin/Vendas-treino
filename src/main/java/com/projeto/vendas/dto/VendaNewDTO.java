package com.projeto.vendas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Produtos;
import com.projeto.vendas.domain.Vendedor;

public class VendaNewDTO {
	
	private LocalDateTime momentoVenda;
	private List<Produtos> produto = new ArrayList<>();
	private Vendedor vendedor;
	private Set<ItensVenda> itensVenda = new HashSet<>();
	
	
	public VendaNewDTO() {
	}
	

	public LocalDateTime getMomentoVenda() {
		return momentoVenda;
	}


	public void setMomentoVenda(LocalDateTime momentoVenda) {
		this.momentoVenda = momentoVenda;
	}


	public List<Produtos> getProduto() {
		return produto;
	}


	public void setProduto(List<Produtos> produto) {
		this.produto = produto;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Set<ItensVenda> getItensVenda() {
		return itensVenda;
	}


	public void setItensVenda(Set<ItensVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	
}

