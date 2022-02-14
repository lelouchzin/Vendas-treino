package com.projeto.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItensVenda> itens = new HashSet<>();
	
	
	public Produtos() {
	}


	public Produtos(Integer id, String nomeProduto, BigDecimal valorProduto) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}

	
	@JsonIgnore
	public List<Venda> getVenda() {
		List<Venda> list = new ArrayList<>();
		for(ItensVenda x : itens) {
			list.add(x.getVenda());
		}
		return list;
	}
	

	public Set<ItensVenda> getItens() {
		return itens;
	}


	public void setItens(Set<ItensVenda> itens) {
		this.itens = itens;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
