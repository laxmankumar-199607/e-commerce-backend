package com.ecommerce.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.core.dto.ItemDTO;
import com.ecommerce.core.model.Item;
import com.ecommerce.core.service.ItemService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("ecom")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/item")
	public ResponseEntity<?> saveItem(@RequestBody ItemDTO itemDTO) {
		Item item = null;
		try {
			item = this.itemService.storeItem(itemDTO);
			return new ResponseEntity<Item>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/item/by/category")
	public ResponseEntity<?> getAllItemsBycategory(@RequestParam Long categoryId) {
		List<ItemDTO> items = null;
		try {
			items = this.itemService.getAllItemsBycategory(categoryId);
			return new ResponseEntity<List<ItemDTO>>(items, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@PutMapping("/item/isactive")
	public ResponseEntity<?> updateActiveItems(@RequestBody ItemDTO itemDTO) {
		Item item = null;
		try {
			item = this.itemService.updateItemPresence(itemDTO);
			return new ResponseEntity<Item>(item, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	@GetMapping("/item/by/search")
	public ResponseEntity<?> getAllItemsBySearch(@RequestParam String itemName) {
		List<ItemDTO> items = null;
		try {
			items = this.itemService.getAllItemsBySearch(itemName);
			return new ResponseEntity<List<ItemDTO>>(items, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
