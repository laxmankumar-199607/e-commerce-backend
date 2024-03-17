package com.ecommerce.core.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "item_name")
	private String itemName;

	@NotBlank
	@Column(name = "item_identifier_code")
	private String itemIdentifierCode;

	@Column(name = "item_image_url")
	private String imageUrl;

//	@Max(252)
	@Column(name = "item_description")
	private String description;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "created_by")
	private String createdBy;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@OneToMany
	@JoinColumn(name = "product_id")
	private Set<Products> products;

	private Boolean isActive;

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Item() {
		super();
	}

	public Item(Long id, @NotBlank String itemName, @NotBlank String categoryIdentifierCode, String imageUrl,
			@Max(252) String description, Date createdOn, String createdBy, Category category) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemIdentifierCode = categoryIdentifierCode;
		this.imageUrl = imageUrl;
		this.description = description;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
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

	public Category getCategory() {
		return category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getItemIdentifierCode() {
		return itemIdentifierCode;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setItemIdentifierCode(String itemIdentifierCode) {
		this.itemIdentifierCode = itemIdentifierCode;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

}
