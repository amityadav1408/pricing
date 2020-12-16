package com.pricing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_PRDT_PRIC_REL")
public class CustPrdtPriceRel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6008847825401163734L;

	@Id
	@Column(name = "cust_prdt_pric_rel_id")
	private Long custPrdtPricRelId;

	@Column(name = "cust_id")
	private Long custId;

	@Column(name = "prdt_id")
	private Long prdtId;

	public Long getCustPrdtPricRelId() {
		return custPrdtPricRelId;
	}

	public void setCustPrdtPricRelId(Long custPrdtPricRelId) {
		this.custPrdtPricRelId = custPrdtPricRelId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getPrdtId() {
		return prdtId;
	}

	public void setPrdtId(Long prdtId) {
		this.prdtId = prdtId;
	}

}