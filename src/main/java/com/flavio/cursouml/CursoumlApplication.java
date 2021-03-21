package com.flavio.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flavio.cursouml.domain.Categoria;
import com.flavio.cursouml.domain.Cidade;
import com.flavio.cursouml.domain.Cliente;
import com.flavio.cursouml.domain.Endereco;
import com.flavio.cursouml.domain.Estado;
import com.flavio.cursouml.domain.Produto;
import com.flavio.cursouml.domain.enums.TipoCliente;
import com.flavio.cursouml.repositories.CategoriaRepository;
import com.flavio.cursouml.repositories.CidadeRepository;
import com.flavio.cursouml.repositories.ClienteRepository;
import com.flavio.cursouml.repositories.EnderecoRepository;
import com.flavio.cursouml.repositories.EstadoRepository;
import com.flavio.cursouml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		Produto p5 = new Produto(null, "Ar Condicionado", 3000.00);

		// Adicionando Produtos aos objetos Cat1 e Cat2 (do tipo Categoria)
		// cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);
		cat1.getProdutos().add(p4);

		cat2.getProdutos().addAll(Arrays.asList(p2, p5));

		// Adicionando Categorias aos objetos p1, p2, p3, p4, p5 (Do tipo Produtos)
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// instanciando Estado
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		// Instanciando Cidade
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c4 = new Cidade(null, "Lavras", est1); 
	
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
	

		est1.getCidades().addAll(Arrays.asList(c1, c4));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		//cliente 
		Cliente cli1 = new Cliente(null, "Maria Silva", "Maria@email.com", "00458294732", 	TipoCliente.PESSOAFISICA);
		
		//Endereco
		Endereco e1 = new Endereco (null, "Rua Flores", "300", "apto 203", "Jardim", "03273090" , cli1, c1); 	 	
		Endereco e2 = new Endereco (null, "Av Paulista", "400", "apto 500", "Bela Vista", "90944010", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2))	;
	}
}
