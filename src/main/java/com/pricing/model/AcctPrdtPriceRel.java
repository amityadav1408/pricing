package com.pricing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCT_PRDT_PRIC_REL")
public class AcctPrdtPriceRel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143164966233557034L;

	@Id
	@Column(name ="acct_prdt_pric_rel_id")
	private Long acctPrdtPricRelId;
	
	
	@Column(name ="acct_id")
	private Long acctId;
	
	
	@Column(name ="prdt_id")
	private Long prdtId;


	public Long getAcctPrdtPricRelId() {
		return acctPrdtPricRelId;
	}


	public void setAcctPrdtPricRelId(Long acctPrdtPricRelId) {
		this.acctPrdtPricRelId = acctPrdtPricRelId;
	}


	public Long getAcctId() {
		return acctId;
	}


	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}


	public Long getPrdtId() {
		return prdtId;
	}


	public void setPrdtId(Long prdtId) {
		this.prdtId = prdtId;
	}


	
	
	
}