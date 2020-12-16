package com.pricing.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6696923375435314436L;

	@Id
	@Column(name ="cust_id")
	private Long custId;

	@Column(name ="glob_cust_id")
	private String globCustId;

	@Column(name ="cust_name")
	private String custName;

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


}
