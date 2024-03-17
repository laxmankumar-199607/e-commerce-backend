package com.ecommerce.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.core.dto.ItemDTO;
import com.ecommerce.core.model.Item;

@Service
public interface ItemService {

	/**
	 * Item Added Aginst Category
	 * 
	 * @param itemDTO
	 * @return
	 * @throws Exception
	 */
	Item storeItem(ItemDTO itemDTO) throws Exception;

	/**
	 * Get all items  by Category Id
	 * 
	 * @param categoryId
	 * @return
	 * @throws Exception
	 */
	List<ItemDTO> getAllItemsBycategory(Long categoryId) throws Exception;

	Item updateItemPresence(ItemDTO itemDTO) throws Exception;

	/**
	 * Get all the items By Searching
	 * 
	 * @param itemName
	 * @return
	 * @throws Exception 
	 */
	List<ItemDTO> getAllItemsBySearch(String itemName) throws Exception;

}
