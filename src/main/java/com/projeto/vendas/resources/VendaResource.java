package com.projeto.vendas.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.vendas.domain.Venda;
import com.projeto.vendas.dto.VendaNewDTO;
import com.projeto.vendas.services.VendaService;

@RestController
@RequestMapping(value="/vendas")
public class VendaResource {

	@Autowired 
	private VendaService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venda> find(@PathVariable Integer id) {
		Venda obj = service.find(id);
		System.out.println(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> insert(@Valid @RequestBody VendaNewDTO objDto) {
//		Venda obj = service.insert(objDto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Venda>> findAll() {
		List<Venda> list = service.findAll();
		return ResponseEntity.ok().body(list);
		}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
}
