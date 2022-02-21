package com.projeto.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItensVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	ItensVendaPK id = new ItensVendaPK();

	private BigDecimal desconto;
	private Integer quantidade;
	private BigDecimal preco;

	public ItensVenda() {
	}

	public ItensVenda(BigDecimal desconto, Integer quantidade, BigDecimal preco, Produtos produto, Venda venda) {
		super();
		id.setVenda(venda);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public BigDecimal getSubTotal() {
		return (preco.subtract(desconto).multiply(BigDecimal.valueOf(quantidade)));
	}

	public ItensVendaPK getId() {
		return id;
	}

	public void setId(ItensVendaPK id) {
		this.id = id;
	}

	@JsonIgnore
	public Venda getVenda() {
		return id.getVenda();
	}
	
	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}

	public Produtos getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produtos produto) {
		id.setProduto(produto);
	}
	
	

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
		ItensVenda other = (ItensVenda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNomeProduto());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço unitario: ");
		builder.append(getPreco());
		builder.append(", SubTotal: ");
		builder.append(getSubTotal());
		builder.append("\n");
		return builder.toString();
	}

}
