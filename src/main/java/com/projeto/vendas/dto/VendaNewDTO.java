package com.projeto.vendas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Produtos;

public class VendaNewDTO {

	private LocalDateTime momentoVenda;
	private List<Produtos> produto = new ArrayList<>();
	private Integer vendedorid;
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

	public Integer getVendedorid() {
		return vendedorid;
	}

	public void setVendedorid(Integer vendedorid) {
		this.vendedorid = vendedorid;
	}

	public Set<ItensVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(Set<ItensVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

}
