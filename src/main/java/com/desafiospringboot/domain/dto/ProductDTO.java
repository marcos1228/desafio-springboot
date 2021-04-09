package com.desafiospringboot.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.desafiospringboot.domain.model.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal price;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String nome, String descricao, BigDecimal price) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.price = price;
	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.nome = product.getNome();
		this.descricao = product.getDescricao();
		this.price = product.getPrice();
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
