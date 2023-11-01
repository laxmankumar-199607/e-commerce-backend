package com.ecommerce.core.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

/**
 * 
 * @author Laxmankumar
 *
 */

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "category_name")
	private String categoryName;

	@NotBlank
	@Column(name = "category_identifier_code")
	private String categoryIdentifierCode;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "description")
	private String description;

	private Date createdOn;

	private String createdBy;
	
	private String routerLink;

	@OneToMany
	@JoinColumn(name = "item_id") // we need to duplicate the physical information
	private Set<Item> items;

	public Category() {
		super();
	}

	public Category(Long id, @NotBlank String categoryName, @NotBlank String categoryIdentifierCode, String imageUrl,
			@Max(252) String description, Date createdOn, String createdBy) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryIdentifierCode = categoryIdentifierCode;
		this.imageUrl = imageUrl;
		this.description = description;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getCategoryIdentifierCode() {
		return categoryIdentifierCode;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategoryIdentifierCode(String categoryIdentifierCode) {
		this.categoryIdentifierCode = categoryIdentifierCode;
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

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public String getRouterLink() {
		return routerLink;
	}

	public void setRouterLink(String routerLink) {
		this.routerLink = routerLink;
	}

}
