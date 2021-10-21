package com.xoriant.ecart.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xoriant.ecart.model.ItemLine;
import com.xoriant.ecart.model.Order;
import com.xoriant.ecart.resource.Sender;

@Service
public class OrderSereviceImpl implements OrderService {

	@Autowired
	private Sender sender;
	
	@Autowired
	private OrderServiceProxy orderServiceProxy;

//	private RestTemplate restTemplate = new RestTemplate();

//	private static final String BASE_URL = "http://localhost:9092/api/cart/";

	Random rand = new Random();
	int upperbound = 2500000;

	@Override
	public Order placeOrder(String user) { // direct order

		ItemLine[] cartItems = orderServiceProxy.getCartItems(user);
		
//				restTemplate.getForObject(BASE_URL + "/" + user, ItemLine[].class);

		double totalAmount = Arrays.stream(cartItems).mapToDouble(line -> (line.getItem().getPrice() * line.getQty()))
				.sum();

		Order order = new Order(6, 1, 1, 3, totalAmount, "8AT7125245323433KK", "Success", LocalDateTime.now());
		
		
		System.out.println(">>>> TOTAL AMOUNT:: " + totalAmount);

		// Send Order Information to the Rabbit MQ
		Map<String, Object> orderInfo = new HashMap<String, Object>();
		orderInfo.put("ORDER_ID", order.getOrderId());
		orderInfo.put("ORDER_DATE", LocalDateTime.now());
		orderInfo.put("TRANSACTION_ID", order.getTransactionId());
		orderInfo.put("TOTAL", order.getTotal());

		// -------------------------------------
		sender.sendOrderDetails(orderInfo);
		// -------------------------------------

		
		// Clear cart items of user
		orderServiceProxy.clearCart(user);
//		restTemplate.delete(BASE_URL+"/"+user);
			
		
		return order;

	}

}
