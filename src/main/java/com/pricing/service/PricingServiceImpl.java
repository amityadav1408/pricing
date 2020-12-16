package com.pricing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.dto.PricingDto;
import com.pricing.repository.AccountRepository;
import com.pricing.repository.AcctPrdtPriceRelRepository;
import com.pricing.repository.CustPrdtPriceRelRepository;
import com.pricing.repository.CustomerRepository;
import com.pricing.repository.ProductPricingRepository;

@Service
public class PricingServiceImpl implements PricingService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ProductPricingRepository pricingRepository;
	
	@Autowired
	AcctPrdtPriceRelRepository acctPrdtPriceRelRepository;
	
	@Autowired
	CustPrdtPriceRelRepository custPrdtPriceRelRepository;
	
	

	public PricingDto getPrice(String custId, String acctNumber) {
		PricingDto pricingDto = new PricingDto();
		// TODO Auto-generated method stub
		pricingDto.setAcctNumber(acctNumber);
		return pricingDto ;
	}
}
