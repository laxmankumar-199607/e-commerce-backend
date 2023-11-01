package com.ecommerce.core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.core.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query(value ="SELECT i.id, i.item_identifier_code, i.created_by, i.created_on, i.item_description,"
			+ " i.item_image_url, i.item_name, i.category_id"
			+ " from items i where i.category_id  = :category_id",nativeQuery = true)
	Item findItemsByCategory(@Param("category_id") Long category_id);
}
