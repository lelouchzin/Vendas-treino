package com.projeto.vendas.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.vendas.domain.Vendedor;
import com.projeto.vendas.dto.VendedorDTO;
import com.projeto.vendas.repositories.VendedorRepository;
import com.projeto.vendas.services.exceptions.ObjectNotFoundException;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repo;

	public Vendedor find(Integer id) {
		Optional<Vendedor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Vendedor.class.getName()));

	}

	@Transactional
	public Vendedor insert(Vendedor obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}

	public List<Vendedor> findAll() {
		return repo.findAll();
	}

	public Vendedor fromDTO(VendedorDTO objDto) {
		return new Vendedor(objDto.getId(), objDto.getNomeVendedor());
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

	public Vendedor update(Vendedor obj) {
		Vendedor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Vendedor newObj, Vendedor obj) {
		newObj.setNomeVendedor(obj.getNomeVendedor());
	}

}
