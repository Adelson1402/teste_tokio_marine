package com.example.api.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.api.domain.Address;
import reactor.core.publisher.Mono;

@Service
public class AddressService {
	
	@Autowired
	private WebClient webClientBean;
	
	private List<Address> list = new ArrayList<Address>();
	
	
	
	public List<Address> listAddress(List<Address> address){
     
      address.stream().forEach(ad -> {
		Mono<Address> addressList = this.webClientBean.method(HttpMethod.GET)
			.uri(ad.getCep() + "/json")	
			.retrieve()
			.bodyToMono(Address.class);
      
		
		Address addressMono = addressList.block();
		
		
		addressMono.setBairro(addressMono.getBairro());
		addressMono.setLogradouro(addressMono.getLogradouro());
		addressMono.setComplemento(addressMono.getComplemento());
		addressMono.setLocalidade(addressMono.getLocalidade());
		addressMono.setUf(addressMono.getUf());
		
      
		
		list.add(addressMono);
      });
		
		
      return  list;
	}

	
	
	
		
	}
	

	

