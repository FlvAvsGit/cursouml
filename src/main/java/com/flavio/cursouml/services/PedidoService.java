package com.flavio.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.cursouml.domain.Categoria;
import com.flavio.cursouml.domain.Pedido;
import com.flavio.cursouml.repositories.PedidoRepository;
import com.flavio.cursouml.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
		
	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
