package com.flavio.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.cursouml.domain.Cliente;
import com.flavio.cursouml.repositories.ClienteRepository;
import com.flavio.cursouml.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
		
	@Autowired
	private ClienteRepository repo;

	public Cliente findCliente(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
