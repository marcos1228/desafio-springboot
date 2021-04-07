package com.desafiospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospringboot.model.Product;
import com.desafiospringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product insert(Product product) {
		return productRepository.save(product);
	}

}
