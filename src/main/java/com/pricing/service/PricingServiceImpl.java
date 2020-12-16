package com.pricing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricing.dto.PricingDto;
import com.pricing.model.Account;
import com.pricing.model.Customer;
import com.pricing.model.ProductPricing;
import com.pricing.repository.AccountRepository;

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

	/*
	 * @Autowired AcctPrdtPriceRelRepository acctPrdtPriceRelRepository;
	 * 
	 * @Autowired CustPrdtPriceRelRepository custPrdtPriceRelRepository;
	 */



	public List<PricingDto> getPrice(String globCustId, String acctNumber) {

		List<PricingDto> pricingDtoList = new ArrayList<>();




		if(globCustId != null) {
			List<ProductPricing> custPriceList = new ArrayList<>();


			Customer customer = customerRepository.findByCustId(globCustId);

			
			Long custPrdctId = customer.getPrdctPricing().getProductId();

			custPriceList = pricingRepository.findByPrdtId(custPrdctId);



			for (ProductPricing productPricing : custPriceList) {
				PricingDto p = new PricingDto(customer.getGlobCustId(), customer.getAcctList().get(0).getAcctNumber(), productPricing.getProductCd(), productPricing.getProductDesc(), productPricing.getProductGroup(), productPricing.getProductCtgry(), productPricing.getPricingCcy(), productPricing.getPricingType(), String.valueOf(productPricing.getPrice()));
				pricingDtoList.add(p);
			}
			
			

			return pricingDtoList;


		}else if(acctNumber != null ){
			
			List<ProductPricing> acctPriceList = new ArrayList<>();
			
			
			Account account =	accountRepository.findByAcctNumber(acctNumber);

			Long acctPrdctId = account.getPrdctPricing().getProductId();

			acctPriceList = pricingRepository.findByPrdtId(acctPrdctId);

			
			for (ProductPricing productPricing : acctPriceList) {
				PricingDto p = new PricingDto(null , account.getAcctNumber(), productPricing.getProductCd(), productPricing.getProductDesc(), productPricing.getProductGroup(), productPricing.getProductCtgry(), productPricing.getPricingCcy(), productPricing.getPricingType(), String.valueOf(productPricing.getPrice()));
				pricingDtoList.add(p);
			}

			return pricingDtoList;


		}else {
			
			List<Customer> cust = customerRepository.findAll();
			
			
			
			System.out.println("cust ID :" +cust.get(0).getCustId() + "acct No :"+ cust.get(0).getAcctList().get(0).getAcctNumber());
			return pricingDtoList;
		}



	}
}
