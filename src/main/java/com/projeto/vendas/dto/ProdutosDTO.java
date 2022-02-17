package com.projeto.vendas.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.projeto.vendas.domain.ItensVenda;
import com.projeto.vendas.domain.Produtos;

public class ProdutosDTO {

	private Integer id;
	private String nomeProduto;
	private BigDecimal valorProduto;
	private Set<ItensVenda> itens = new HashSet<>();

	public ProdutosDTO() {
	}

	public ProdutosDTO(Produtos obj) {
		id = obj.getId();
		nomeProduto = obj.getNomeProduto();
		valorProduto = obj.getValorProduto();

	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ItensVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItensVenda> itens) {
		this.itens = itens;
	}

}
