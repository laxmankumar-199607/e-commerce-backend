package com.ecommerce.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.core.model.Category;
import com.ecommerce.core.repository.ICategoryRepository;
import com.ecommerce.core.service.ICategoriesService;

@Component
public class CategoriesServiceImpl implements ICategoriesService {

	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Category storeCategory(Category category) throws Exception {
		category.setCreatedOn(new Date());
		try {
			return this.categoryRepository.save(category);
		} catch (Exception e) {
			throw new Exception("Failed to store student data");
		}
	}

	@Override
	public List<Category> getAllCategory()throws Exception {
	
		List<Category> listCategory = null;
		
		listCategory = (List<Category>) this.categoryRepository.findAll();
		if(listCategory.isEmpty() || listCategory.size() == 0) {
			throw new Exception(" Categories not exists");
		}
		
		return listCategory;
	}

}
