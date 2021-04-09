package com.desafiospringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiospringboot.domain.dto.ProductDTO;
import com.desafiospringboot.domain.model.Product;
import com.desafiospringboot.repository.ProductRepository;
import com.desafiospringboot.service.exception.OjectNotFoundException;

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
			productRepository.save(product);
		}
		return new ProductDTO();
	}

	public Product fromDTO(ProductDTO productDto) {
		Product product = new Product(null, productDto.getNome(), productDto.getDescricao(), productDto.getPrice());
		return product;
	}

	public Product buscarPorId(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(
				() -> new OjectNotFoundException("Product não encontrado! id: " + id + ",Tipo " + product.getClass()));
	}

	public void delete(Long id) {
		buscarPorId(id);
		productRepository.deleteById(id);

	}

	public List<ProductDTO> listarProduct() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDto = new ArrayList<>();
		for (Product p : products) {
			productDto.add(new ProductDTO(p));
		}

		return productDto;
	}

}
