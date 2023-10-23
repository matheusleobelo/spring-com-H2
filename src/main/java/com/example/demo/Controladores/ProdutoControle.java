package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelos.Produto;
import com.example.demo.Repositorio.RepositorioProduto;

@RestController
@RequestMapping(value="/controladorbasico")
public class ProdutoControle {
	
	@Autowired
	RepositorioProduto repositorioProduto;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return (List<Produto>) repositorioProduto.findAll();	

	}
}


