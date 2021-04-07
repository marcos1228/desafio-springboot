package com.desafiospringboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
	public ResponseEntity<?> update(@RequestBody ProductDTO productDto, @PathVariable Long id){
		productDto.setId(id);
		productService.update(productDto);
		return ((BodyBuilder) ResponseEntity.notFound()).body(productDto);
	}
	

 }
