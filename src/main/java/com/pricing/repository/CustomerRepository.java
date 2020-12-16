package com.pricing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pricing.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Long>{

    List<Customer> findAll(); 

}


