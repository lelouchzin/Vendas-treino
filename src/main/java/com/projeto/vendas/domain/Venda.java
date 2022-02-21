package com.projeto.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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
	private LocalDateTime momentoVenda;

	@JsonIgnore
	@OneToMany(mappedBy = "venda")
	private List<Produtos> produto = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;

	@OneToMany(mappedBy = "id.venda", cascade = CascadeType.ALL)
	private Set<ItensVenda> itensVenda = new HashSet<>();

	public Venda() {
	}

	public Venda(Integer id, LocalDateTime momentoVenda, Vendedor vendedor) {
		super();
		this.id = id;
		this.momentoVenda = momentoVenda;
		this.vendedor = vendedor;
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.valueOf(0);
		for (ItensVenda iv : itensVenda) {
			soma = soma.add(iv.getSubTotal());
		}
		return soma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", momentoVenda=" + momentoVenda + ", produto=" + produto + ", vendedor=" + vendedor
				+ ", itensVenda=" + itensVenda + "]";
	}

}