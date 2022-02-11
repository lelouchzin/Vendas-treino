package com.projeto.vendas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.services.VendaService;

@RestController
@RequestMapping(value="/vendas")
public class VendaResource {

	@Autowired 
	private VendaService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venda> find(@PathVariable Integer id) {
		Venda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
