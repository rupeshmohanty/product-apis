package com.example.demo.ProductManagementSystem.repository;

import com.example.demo.ProductManagementSystem.entity.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer>{
    
}
