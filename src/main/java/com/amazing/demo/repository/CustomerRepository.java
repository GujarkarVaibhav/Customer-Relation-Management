package com.amazing.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazing.demo.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long>{

}
