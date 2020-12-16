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
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6696923375435314436L;

	@Id
	@Column(name = "cust_id")
	private Long custId;

	@Column(name = "glob_cust_id")
	private String globCustId;

	@Column(name = "cust_name")
	private String custName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "cust_prdt_pric_rel", joinColumns = @JoinColumn(name = "cust_id"), inverseJoinColumns = @JoinColumn(name = "prdt_id"))
	private ProductPricing prdctPricing;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "account", joinColumns = @JoinColumn(name = "cust_id"), inverseJoinColumns = @JoinColumn(name = "acct_id"))
	@MapKey(name = "custId")
	private List<Account> acctList;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getGlobCustId() {
		return globCustId;
	}

	public void setGlobCustId(String globCustId) {
		this.globCustId = globCustId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public ProductPricing getPrdctPricing() {
		return prdctPricing;
	}

	public void setPrdctPricing(ProductPricing prdctPricing) {
		this.prdctPricing = prdctPricing;
	}

	public List<Account> getAcctList() {
		return acctList;
	}

	public void setAcctList(List<Account> acctList) {
		this.acctList = acctList;
	}

}
