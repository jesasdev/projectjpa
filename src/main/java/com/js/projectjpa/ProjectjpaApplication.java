package com.js.projectjpa;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.js.projectjpa.domain.Categoria;
import com.js.projectjpa.domain.Produto;
import com.js.projectjpa.repositories.CategoriaRepository;
import com.js.projectjpa.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjectjpaApplication implements CommandLineRunner {
	
    @Autowired
	CategoriaRepository categoriaRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(ProjectjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",5200.00);
		Produto p2 = new Produto(null,"Impressora",560.00);
		Produto p3 = new Produto(null,"Mouse",80.00);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
