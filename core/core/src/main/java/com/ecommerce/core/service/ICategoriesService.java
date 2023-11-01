package com.ecommerce.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.core.model.Category;

@Service
public interface ICategoriesService {

	/**
	 * Service to Create Category
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 */
	Category storeCategory(Category category) throws Exception;

	/**
	 * Service to Get all Categories
	 * 
	 * @return
	 * @throws Exception 
	 */
	List<Category> getAllCategory() throws Exception;

}
