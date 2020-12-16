package com.pricing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String custId;

	public Long getAcctId() {
		return acctId;
	}

	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	public String getAcctNum() {
		return acctNumber;
	}

	public void setAcctNum(String acctNum) {
		this.acctNumber = acctNum;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	
}
