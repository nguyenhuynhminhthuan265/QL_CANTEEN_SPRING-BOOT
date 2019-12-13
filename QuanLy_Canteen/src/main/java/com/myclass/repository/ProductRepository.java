package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
