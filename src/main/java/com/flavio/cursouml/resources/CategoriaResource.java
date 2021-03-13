package com.flavio.cursouml.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flavio.cursouml.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")

public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	private List<Categoria> listar() {
		
		Categoria cat1  = new Categoria( 1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> catlist = new ArrayList<Categoria>();
		catlist.add(cat1);
		catlist.add(cat2);
		
		return catlist;

	}
	
}
