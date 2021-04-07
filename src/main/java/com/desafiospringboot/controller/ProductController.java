package com.desafiospringboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiospringboot.model.Product;
import com.desafiospringboot.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<?> salvar(@RequestBody Product product) {
		Product obj = productService.insert(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(product);
	}

	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id){
		product.setId(id);
		productService.update(product);
		return ((BodyBuilder) ResponseEntity.notFound()).body(null);
	}
}
