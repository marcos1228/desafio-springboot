package com.desafiospringboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAD_PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "NO_PRODUCT")
	private String nome;
	@Column(name = "DS_PROCUCT")
	private String descricao;
	@Column(name = "NU_PRICE")
	private BigDecimal price;
}
