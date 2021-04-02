package com.example.api.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;
	
	
	@Autowired
	private AddressService addressService;
	
	

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public ResponseEntity<Page<Customer>> findAllPageable(Pageable pageable){
		return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.FOUND);
	}
	
	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}
	
	public ResponseEntity<?> saveCustomer(Customer customer){
		addressService.listAddress(customer.getAddress()).clear();
	    customer.setAddress(addressService.listAddress(customer.getAddress()));
	    customer.getAddress().forEach(customerRequest -> {customerRequest.setId(null);});
		repository.save(customer); 
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> updateCustomer(Customer customer){
		customer.setName(customer.getName());
		customer.setEmail(customer.getEmail());
		if(addressService.listAddress(customer.getAddress())!=null) {
			customer.setAddress(addressService.listAddress(customer.getAddress()));
		}
		repository.save(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public ResponseEntity<?> deleteCustomer(Customer customer) {
		
		repository.delete(customer);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}

}
