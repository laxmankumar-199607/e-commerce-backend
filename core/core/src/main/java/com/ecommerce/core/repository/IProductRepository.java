package com.ecommerce.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.core.model.Products;

public interface IProductRepository extends CrudRepository<Products, Long> {

}
