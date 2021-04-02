package com.example.api.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.service.AddressService;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
@Transactional
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private AddressService addressService;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/pages")
	public ResponseEntity<Page<Customer>> findAllPageable(@PageableDefault (sort="name",
	                                                        direction = Sort.Direction.ASC,
	                                                        page = 0,
	                                                        size = 5) Pageable pageable){
		
		if(service.findAllPageable(pageable).getBody().isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return service.findAllPageable(pageable);
		
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}
	
	
    @PostMapping("/save") 
    @Transactional
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customer){
    	
		return service.saveCustomer(customer);	
	}
    
    
    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer){
    	 
    	return new ResponseEntity<>(service.updateCustomer(customer),HttpStatus.ACCEPTED);
    	
    }
    
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestBody Customer customer){
    	return service.deleteCustomer(customer);
    	
    }
}
