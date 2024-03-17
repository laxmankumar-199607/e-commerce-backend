package com.ecommerce.core.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.core.dto.ItemDTO;
import com.ecommerce.core.model.Category;
import com.ecommerce.core.model.Item;

public class CoreMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Item convertToEntity(ItemDTO itemDto, Category category) {

		Item item = this.modelMapper.map(itemDto, Item.class);

		item.setCategory(category);
		return item;
	}
}
