package com.projeto.vendas.dto;

import java.math.BigDecimal;

import com.projeto.vendas.domain.Produtos;

public class ProdutosDTO {

	private Integer id;
	private String nomeProduto;
	private BigDecimal valorProduto;
	

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

}
