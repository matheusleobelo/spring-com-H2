package com.example.demo.Modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clienteId")
	public Long clienteId;
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
	public String nome;
	@Column(name = "cnpj", columnDefinition="VARCHAR(14)", unique = true, nullable = false)
	public String cnpj;
	@Column(name = "email", columnDefinition="VARCHAR(40)", nullable = false)
	public String email;
	@Column(name = "telefone", columnDefinition="VARCHAR(12)", nullable = false)
	public String telefone;
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Produto> produtos;
	
}
