package com.flavio.cursouml.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")

public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	private String listar() {
		return "Meu Segundo Metodo Rest";

	}
	
}