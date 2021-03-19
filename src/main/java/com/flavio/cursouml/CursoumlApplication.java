package com.flavio.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flavio.cursouml.domain.Categoria;
import com.flavio.cursouml.domain.Produto;
import com.flavio.cursouml.repositories.CategoriaRepository;
import com.flavio.cursouml.repositories.ProdutoRepository;

import javassist.compiler.ast.ASTList;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

// instanciando a Categoria
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

//	Instanciando os Produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Monitor LED", 1780.00);
		Produto p5 = new Produto(null, "Ar Condicionado", 3000.00)
;
		
// Adicionando Produtos aos objetos Cat1 e Cat2 (do tipo Categoria)
		//cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);
		cat1.getProdutos().add(p4);
		
		cat2.getProdutos().addAll(Arrays.asList(p2, p5));
	
//	Adicionando Categorias aos objetos p1, p2, p3, p4, p5 (Do tipo Produtos)
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
}
