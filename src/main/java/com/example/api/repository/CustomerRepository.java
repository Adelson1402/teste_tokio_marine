package com.example.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;

import com.example.api.domain.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();
	

}
