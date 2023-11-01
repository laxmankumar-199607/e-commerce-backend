package com.ecommerce.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ecommerce.core.dto.ItemDTO;
import com.ecommerce.core.query.SQL;

@Repository
public class ItemQueryRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ItemDTO> getAllItemByCategory(Long categoryId){
		
		RowMapper<ItemDTO> mapper = new RowMapper<ItemDTO>() {

			public ItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setCategoryId(rs.getLong("category_id"));
				itemDTO.setCreatedBy(rs.getString("created_by"));
				itemDTO.setCreatedOn(rs.getDate("created_on"));
				itemDTO.setDescription(rs.getString("item_description"));
				itemDTO.setId(rs.getLong("id"));
				itemDTO.setImageUrl(rs.getString("item_image_url"));
				itemDTO.setItemIdentifierCode(rs.getString("item_identifier_code"));
				itemDTO.setItemName(rs.getString("item_name"));
				itemDTO.setIsActive(rs.getBoolean("is_active"));
				
				return itemDTO;
				
			}
		};
		List<ItemDTO> resultList = this.jdbcTemplate.query(SQL.getAllItemByCategory(categoryId), mapper);

		return resultList;
		
	}
}
