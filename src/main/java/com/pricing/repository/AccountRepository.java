package com.pricing.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pricing.model.Account;


public interface AccountRepository extends JpaRepository<Account , Long>{


}


