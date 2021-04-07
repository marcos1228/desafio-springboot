package com.desafiospringboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospringboot.domain.dto.ProductDTO;
import com.desafiospringboot.domain.model.Product;
import com.desafiospringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product insert(Product product) {
		return productRepository.save(product);
	}

	public ProductDTO update(ProductDTO productDto) {
		Optional<Product> optional = productRepository.findById(productDto.getId());
		if (optional.isPresent()) {
			Product product = optional.get();
			product.setNome(productDto.getNome());
			product.setDescricao(productDto.getDescricao());
			product.setPrice(productDto.getPrice());
		}
		return new ProductDTO();
	}

	public Product fromDTO(ProductDTO productDto) {
		Product product = new Product(null, productDto.getNome(), productDto.getDescricao(), productDto.getPrice());
		return product;
	}

}
