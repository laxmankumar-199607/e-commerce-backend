package com.ecommerce.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.core.model.Category;
import com.ecommerce.core.service.ICategoriesService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("ecom")
public class CategoryController {
	
	@Autowired
	ICategoriesService categoriesService;
	
	@PostMapping("/category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		Category ctgry = null;
		try {
			ctgry = this.categoriesService.storeCategory(category);
			return new ResponseEntity<Category>(ctgry, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/category/all")
	public ResponseEntity<?> getAllStudent() {
		List<Category> ctgry = null;
		try {
			ctgry = this.categoriesService.getAllCategory();
			return new ResponseEntity<List<Category>>(ctgry, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
