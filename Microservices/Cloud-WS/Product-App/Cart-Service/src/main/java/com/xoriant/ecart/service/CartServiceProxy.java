package com.xoriant.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.ecart.model.Product;

@FeignClient(name="search-service")
public interface CartServiceProxy {
	
	
	@GetMapping("/api/products/{id}")
	public Product findById(@PathVariable int id);

}
