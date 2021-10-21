package com.xoriant.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.ecart.model.ItemLine;

@FeignClient(name="cart-service")
public interface OrderServiceProxy {
	
	@GetMapping("/api/cart/{user}")
	public ItemLine[] getCartItems(@PathVariable String user);
	
	@DeleteMapping("/api/cart/{user}")
	public void clearCart(@PathVariable String user);
		
	

}