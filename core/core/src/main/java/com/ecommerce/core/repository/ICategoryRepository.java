package com.ecommerce.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.core.model.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

	
}
