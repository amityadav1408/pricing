package com.pricing.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICING")
public class ProductPricing implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2236084871234957762L;
	
	@Id
	@Column(name ="prdt_id")
	private Long productId;
	
	@Column(name ="prdt_cd")
	private String productCd;
	
	@Column(name ="prdt_desc")
	private String productDesc;
	
	@Column(name ="prdt_group")
	private String productGroup;
	
	@Column(name ="prdt_ctgry")
	private String productCtgry;
	
	@Column(name ="pricing_ccy")
	private String pricingCcy;
	
	@Column(name ="pricing_typ")
	private String pricingType;
	
	@Column(name ="price")
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="customer", joinColumns = @JoinColumn(name="prdt_id"),
	inverseJoinColumns = @JoinColumn(name="cust_id"))
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="account", joinColumns = @JoinColumn(name="prdt_id"),
	inverseJoinColumns = @JoinColumn(name="acct_id"))
	private Account account;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductCtgry() {
		return productCtgry;
	}

	public void setProductCtgry(String productCtgry) {
		this.productCtgry = productCtgry;
	}

	public String getPricingCcy() {
		return pricingCcy;
	}

	public void setPricingCcy(String pricingCcy) {
		this.pricingCcy = pricingCcy;
	}

	public String getPricingType() {
		return pricingType;
	}

	public void setPricingType(String pricingType) {
		this.pricingType = pricingType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
	
}
