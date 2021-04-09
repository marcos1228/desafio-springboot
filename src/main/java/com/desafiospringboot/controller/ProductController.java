package com.desafiospringboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiospringboot.domain.dto.ProductDTO;
import com.desafiospringboot.domain.model.Product;
import com.desafiospringboot.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<?> salvar(@RequestBody ProductDTO productDto) {
		productDto.setId(null);
		Product obj = productService.fromDTO(productDto);
		obj = productService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody ProductDTO productDto, @PathVariable Long id) {
		productDto.setId(id);
		productService.update(productDto);
		return ((BodyBuilder) ResponseEntity.notFound()).body(productDto);
	}

	@Description("Busca de um produto por ID")
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
		Product product = productService.buscarPorId(id);
		return ResponseEntity.ok().body(product);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.ok().build();

	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> listar() {
		return ResponseEntity.ok(productService.listarProduct());
	}
}
