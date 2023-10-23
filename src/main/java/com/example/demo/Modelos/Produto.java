package com.example.demo.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produtoId")
	public Long produtoId;
	@Column(name = "nome", columnDefinition = "VARCHAR(50)", nullable = false)
	public String nome;
	@Column(name = "preco", columnDefinition = "VARCHAR(30)", nullable = true)
	public String preco;
	@Column(name = "descricao", columnDefinition = "VARCHAR(220)", nullable = false)
	public String descricao;
	@Column(name = "categoria", columnDefinition = "VARCHAR(30)", nullable = false)
	public String categoria;
	@ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    public Cliente cliente;
}
