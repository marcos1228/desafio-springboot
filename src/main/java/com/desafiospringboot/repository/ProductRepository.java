package com.desafiospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiospringboot.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
