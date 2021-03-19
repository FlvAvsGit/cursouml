package com.flavio.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.cursouml.domain.Categoria;
import com.flavio.cursouml.repositories.CategoriaRepository;
import com.flavio.cursouml.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
		
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
