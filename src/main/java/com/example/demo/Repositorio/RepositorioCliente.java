package com.example.demo.Repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Modelos.Cliente;

public interface RepositorioCliente extends CrudRepository<Cliente, Long>{

}
