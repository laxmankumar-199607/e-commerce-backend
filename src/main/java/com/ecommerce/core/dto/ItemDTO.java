package com.ecommerce.core.dto;

import java.util.Date;

public class ItemDTO {

	private Long id;

	private String itemName;

	private String itemIdentifierCode;

	private String imageUrl;

	private String description;

	private Date createdOn;

	private String createdBy;

	private Long categoryId;
	
	private Boolean isActive;

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ItemDTO() {
		super();
	}

	public ItemDTO(Long id, String itemName, String itemIdentifierCode, String imageUrl, String description,
			Date createdOn, String createdBy, Long categoryId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.setItemIdentifierCode(itemIdentifierCode);
		this.imageUrl = imageUrl;
		this.description = description;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	

	public String getImageUrl() {
		return imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemIdentifierCode() {
		return itemIdentifierCode;
	}

	public void setItemIdentifierCode(String itemIdentifierCode) {
		this.itemIdentifierCode = itemIdentifierCode;
	}

}
