package com.pricing.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_PRDT_PRIC_REL")
public class CustPrdtPriceRel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6008847825401163734L;
	
	@Id
	@Column(name ="cust_prdt_pric_rel_id")
	private Long custPrdtPricRelId;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@Column(name ="cust_id")
	private Customer customer;
	
	@Column(name ="prdt_id")
	private Long prdtId;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Customer", 
		joinColumns = { @JoinColumn(name = "custId", referencedColumnName = "customer")})
	@MapKey(name = "custId")
	private List<ProductPricing> productList;

	public Long getCustPrdtPricRelId() {
		return custPrdtPricRelId;
	}

	public void setCustPrdtPricRelId(Long custPrdtPricRelId) {
		this.custPrdtPricRelId = custPrdtPricRelId;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getPrdtId() {
		return prdtId;
	}

	public void setPrdtId(Long prdtId) {
		this.prdtId = prdtId;
	}

	
}
