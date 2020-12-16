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
@Table(name = "ACCOUNT")
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8605537396355267593L;
	
	@Id
	@Column(name ="acct_id")
	private Long acctId;
	
	@Column(name ="acct_num")
	private String acctNumber;
	
	@Column(name ="cust_id")
	private Long custId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="acct_prdt_pric_rel", joinColumns = @JoinColumn(name="acct_id"),
	inverseJoinColumns = @JoinColumn(name="prdt_id"))
	private ProductPricing prdctPricing;

	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public ProductPricing getPrdctPricing() {
		return prdctPricing;
	}

	public void setPrdctPricing(ProductPricing prdctPricing) {
		this.prdctPricing = prdctPricing;
	}

	
	
}
