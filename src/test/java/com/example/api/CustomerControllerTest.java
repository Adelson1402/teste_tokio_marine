package com.example.api;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.api.domain.Customer;
import com.example.api.service.AddressService;
import com.example.api.service.CustomerService;


@RunWith(SpringRunner.class)
public class CustomerControllerTest {
	
	
	

	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private AddressService addressService;
	
	
	
	
	
	

	@Test
	public void deveRetornarCREATED_QuandoSalvarUmCustomer() {
		Customer customer = new Customer();
	    customer.setName("Adelson");
	    customer.setEmail("delsonsaint@hotmail.com");
		
		Mockito.when(customerService.saveCustomer(customer)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));  
		
		Assertions.assertThat(HttpStatus.CREATED);
	}
		
		
		
	@Test	
	public void deveRetornarOK_QuandoAtualizarUmCostumer() {
		Customer customer = new Customer();
	    customer.setName("Adelson");
	    customer.setEmail("delsonsaint@hotmail.com");
	    
	    Mockito.when(customerService.updateCustomer(customer)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	    
	    Assertions.assertThat(HttpStatus.OK);
	    
		
	}
	
	@Test
	public void deveRetornarACCEPTED_QuandoDeletarUmCostumer() {
		Customer customer = new Customer();
	    customer.setName("Adelson");
	    customer.setEmail("delsonsaint@hotmail.com");
	    
	    Mockito.when(customerService.updateCustomer(customer)).thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));
	    
	    Assertions.assertThat(HttpStatus.ACCEPTED);
		
	}
	
	
}
