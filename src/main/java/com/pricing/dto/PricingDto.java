package com.pricing.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PricingDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3178798109346200337L;
	
	
	@JsonProperty("globCustId")
	private String globCustId;
	
	@JsonProperty("acctNumber")
	private String acctNumber;
	
	@JsonProperty("prdctCd")
	private String prdctCd;
	
	@JsonProperty("prdctDesc")
	private String prdctDesc;
	
	@JsonProperty("prdctGrp")
	private String prdctGrp;
	
	@JsonProperty("prdctCtgry")
	private String prdctCtgry;
	
	@JsonProperty("pricingCcy")
	private String pricingCcy;
	
	@JsonProperty("pricingType")
	private String pricingType;
	
	@JsonProperty("price")
	private String price;

	public String getGlobCustId() {
		return globCustId;
	}

	public void setGlobCustId(String globCustId) {
		this.globCustId = globCustId;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getPrdctCd() {
		return prdctCd;
	}

	public void setPrdctCd(String prdctCd) {
		this.prdctCd = prdctCd;
	}

	public String getPrdctDesc() {
		return prdctDesc;
	}

	public void setPrdctDesc(String prdctDesc) {
		this.prdctDesc = prdctDesc;
	}

	public String getPrdctGrp() {
		return prdctGrp;
	}

	public void setPrdctGrp(String prdctGrp) {
		this.prdctGrp = prdctGrp;
	}

	public String getPrdctCtgry() {
		return prdctCtgry;
	}

	public void setPrdctCtgry(String prdctCtgry) {
		this.prdctCtgry = prdctCtgry;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
}
