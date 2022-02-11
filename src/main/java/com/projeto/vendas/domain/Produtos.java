package com.projeto.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeProduto;
	private BigDecimal valorProduto;
	
	@ManyToOne
	@JoinColumn(name ="vendas_id")
	private Venda vendas;
	
	
	public Produtos() {
	}


	public Produtos(Integer id, String nomeProduto, BigDecimal valorProduto) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Venda getVendas() {
		return vendas;
	}


	public void setVendas(Venda vendas) {
		this.vendas = vendas;
	}
	
	
	

}
