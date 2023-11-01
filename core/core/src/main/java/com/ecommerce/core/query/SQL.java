package com.ecommerce.core.query;

public class SQL {

	public static final String getAllItemByCategory(Long categoryId) {

		return "SELECT i.id, i.item_identifier_code, i.created_by, i.created_on, i.item_description,"
				+ " i.item_image_url, i.item_name, i.category_id, i.is_active" + " from items i where i.category_id  = " + categoryId
				+ "";
	}
}
