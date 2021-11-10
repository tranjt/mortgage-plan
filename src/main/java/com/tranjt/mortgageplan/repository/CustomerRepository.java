package com.tranjt.mortgageplan.repository;


import com.tranjt.mortgageplan.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
