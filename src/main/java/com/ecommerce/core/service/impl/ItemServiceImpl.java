package com.ecommerce.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.core.dto.ItemDTO;
import com.ecommerce.core.model.Category;
import com.ecommerce.core.model.Item;
import com.ecommerce.core.repository.ICategoryRepository;
import com.ecommerce.core.repository.ItemQueryRepo;
import com.ecommerce.core.repository.ItemRepository;
import com.ecommerce.core.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ICategoryRepository categoryRepository;

	@Autowired
	ItemQueryRepo itemQueryRepo;

	@Override
	public Item storeItem(ItemDTO itemDTO) throws Exception {
		Category category = null;

		try {
			Item item = new Item();
			item.setDescription(itemDTO.getDescription());
			item.setCreatedBy(itemDTO.getCreatedBy());
			item.setImageUrl(itemDTO.getImageUrl());
			item.setItemName(itemDTO.getItemName());
			item.setItemIdentifierCode(itemDTO.getItemIdentifierCode());

			category = this.categoryRepository.findById(itemDTO.getCategoryId()).get();
			item.setCategory(category);
			item.setCreatedOn(new Date());
			return this.itemRepository.save(item);
		} catch (Exception e) {
			throw new Exception("Exception");
		}

	}

	@Override
	public List<ItemDTO> getAllItemsBycategory(Long categoryId) throws Exception {
		List<ItemDTO> itemList = null;
		try {
			itemList = this.itemQueryRepo.getAllItemByCategory(categoryId);
		} catch (Exception e) {
			throw new Exception("Exception in finding items");
		}

		return itemList;
	}

	@Override
	public Item updateItemPresence(ItemDTO itemDTO) throws Exception {

		Item item = new Item();

		try {
			item = this.itemRepository.findById(itemDTO.getId()).get();

			item.setIsActive(itemDTO.getIsActive());

			item = this.itemRepository.save(item);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public List<ItemDTO> getAllItemsBySearch(String itemName) throws Exception {
		List<ItemDTO> itemList = null;
		try {
			itemList = this.itemQueryRepo.getAllItemBySearch(itemName);
		} catch (Exception e) {
			throw new Exception("Exception in finding items");
		}

		return itemList;
	}

}
