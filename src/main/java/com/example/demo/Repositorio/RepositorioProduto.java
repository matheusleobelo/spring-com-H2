package com.example.demo.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Modelos.Produto;

public interface RepositorioProduto extends CrudRepository<Produto, Long>{
	List<Produto> findAllByClienteClienteId(Long id);
}
