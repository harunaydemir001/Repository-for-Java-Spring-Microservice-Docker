package com.innova.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innova.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByOrderByPriceDesc();// (Fiyata göre artan azalan listeleme)
	List<Product> findByOrderByPriceAsc();
}
