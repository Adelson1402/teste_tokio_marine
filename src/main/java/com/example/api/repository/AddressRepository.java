package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.api.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query(value="select * from address where id_customer like 1", nativeQuery = true)
	List<Address> findByCustomer();

	

	

}
