package com.generation.crud_farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório.")
	@Size(max = 100, message = "O atributo nome deve conter no máximo 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "O atributo descricao é obrigatório.")
	@Size(max = 500, message = "O atributo descricao deve conter no máximo 500 caracteres.")
	private String descricao;
	
	@NotNull(message = "O atributo preco é obrigatório.")
	@Digits(integer = 8, fraction = 2, message = "O atributo preco deve deve conter no máximo 8 casas inteiras e 2 decimais.")
	private BigDecimal preco;
	
	@NotNull(message = "O atributo estoque é obrigatório.")
	private Integer estoque;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	@NotNull(message = "O atributo categoria é obrigatório.")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
