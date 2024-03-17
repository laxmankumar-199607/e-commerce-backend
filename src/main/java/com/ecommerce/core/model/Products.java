package com.ecommerce.core.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "prod_name")
	private String prodName;

	@NotBlank
	@Column(name = "prod_identifier_code")
	private String prodIdentifierCode;

	@Column(name = "prod_image_url")
	private String prodImageUrl;
	
	
	@Column(name = "prod_price")
	private Long prodPrice;
	
	
	@Column(name = "prod_price_unit")
	private String prodPriceUnit;

//	@Max(252)
	@Column(name = "prod_description")
	private String prodDescription;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "created_by")
	private String createdBy;
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public Long getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Long prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdPriceUnit() {
		return prodPriceUnit;
	}

	public void setProdPriceUnit(String prodPriceUnit) {
		this.prodPriceUnit = prodPriceUnit;
	}

}
