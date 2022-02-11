package com.projeto.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal valorVenda;
	private LocalDateTime momentoCompra;

	@JsonIgnore
	@OneToMany(mappedBy = "vendas")
	private List<Produtos> produto = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name= "vendedor_id")
	private Vendedor vendedor;

	public Venda() {
	}

	public Venda(Integer id, BigDecimal valorVenda, LocalDateTime momentoCompra) {
		super();
		this.id = id;
		this.valorVenda = valorVenda;
		this.momentoCompra = momentoCompra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public LocalDateTime getMomentoCompra() {
		return momentoCompra;
	}

	public void setMomentoCompra(LocalDateTime momentoCompra) {
		this.momentoCompra = momentoCompra;
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
	
	
	

}