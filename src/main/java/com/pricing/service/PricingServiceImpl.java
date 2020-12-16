package com.pricing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pricing.dto.PricingDto;
import com.pricing.model.Account;
import com.pricing.model.AcctPrdtPriceRel;
import com.pricing.model.CustPrdtPriceRel;
import com.pricing.model.Customer;
import com.pricing.model.ProductPricing;
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
	
	

	public PricingDto getPrice(String glbCustId, String acctNumber) {
		PricingDto pricingDto = new PricingDto();
		String custId = null;
		String acctId = null;
		 
		List<Customer> custList = new ArrayList<>();
		List<Account> acctList = new ArrayList<>();
		List<AcctPrdtPriceRel> acctPrdctPriceList = new ArrayList<>();
		List<CustPrdtPriceRel> custPrdctPriceList = new ArrayList<>();
		List<ProductPricing> priceList = new ArrayList<>();
		
		custList = customerRepository.findByCustId(glbCustId);
		acctList =	accountRepository.findByAcctNum(acctNumber);
		
		acctPrdctPriceList = acctPrdtPriceRelRepository.findByAcctId(acctId);
		custPrdctPriceList = custPrdtPriceRelRepository.findByCustId(custId);
				
		return pricingDto ;
	}
}
