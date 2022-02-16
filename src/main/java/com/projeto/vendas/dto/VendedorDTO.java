package com.projeto.vendas.dto;

import java.util.ArrayList;
import java.util.List;

import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.domain.Vendedor;

public class VendedorDTO {

	private Integer id;
	private String nomeVendedor;
	private List<Venda> vendas = new ArrayList<>();

	public VendedorDTO() {
	}

	public VendedorDTO(Vendedor obj) {
		id = obj.getId();
		nomeVendedor = obj.getNomeVendedor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

}
