package com.example.demo;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.Modelos.Cliente;
import com.example.demo.Modelos.Produto;
import com.example.demo.Repositorio.RepositorioCliente;
import com.example.demo.Repositorio.RepositorioProduto;

@SpringBootApplication
public class ExemploJpa1NApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploJpa1NApplication.class, args);
    }

    @Bean
    public CommandLineRunner inserindoCliente(RepositorioCliente repositorioCliente) {
        return (args) -> {
            try {
                Cliente cliente = new Cliente();

                cliente.nome = "Robson";
                cliente.cnpj = "12312312312";
                cliente.email = "01234546@gmail.com";
                cliente.telefone = "01234546";
                

                cliente = repositorioCliente.save(cliente);
                System.out.println("Cliente salvo com ID: " + cliente.clienteId);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }

    @Primary
    @Bean
    public CommandLineRunner inserindoProduto(RepositorioCliente repositorioCliente,
            RepositorioProduto repositorioProduto) {
        return (args) -> {
            try {
                Optional<Cliente> cliente = repositorioCliente.findById(1L);
                if (cliente.isPresent()) {
                    Produto produto = new Produto();
                    produto.nome = "pao";
                    produto.preco = "R$10";
                    produto.descricao = "farinha de trigo";
                    produto.categoria = "Alimento";
                    produto.cliente = cliente.get();
                    produto = repositorioProduto.save(produto);
                    System.out.println("Produto salvo com ID: " + produto.produtoId);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
