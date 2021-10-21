package com.xoriant.ecart.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.model.Order;
import com.xoriant.ecart.service.ProductService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RabbitTemplate rt;
	
	private RestTemplate rest=new RestTemplate();
	
	
	@Bean
	public Queue order() {
		return new Queue("OrderQ",false);
	}
	
	@Bean
	public Queue inventory() {
		return new Queue("InventoryQ",false);
	}
	
	@RabbitListener(queues = "OrderQ")
	public void readMessage(Map<String,Object> orderInfo) {
		
		System.out.println("Order Details =="+orderInfo);
		
		Double price = rest.getForObject("http://localhost:9090/api/price/"+orderInfo.get("productId"),Double.class);
//		System.out.println("Product ID: "+orderInfo.get("PID"));
//		System.out.println("Product Quantity: "+orderInfo.get("QTY"));
//		System.out.println("Product Price: "+orderInfo.get("PRICE"));
//		System.out.println("Order Date: "+orderInfo.get("DATE"));
//		System.out.println("Order Time: "+orderInfo.get("TIME"));
//		System.out.println("User Id: "+orderInfo.get("user_id"));
//		System.out.println("Transcation Id: "+orderInfo.get("trx_id"));
	
		
		Order order = new Order((int)orderInfo.get("orderID"),(int)orderInfo.get("user_id"),(int)orderInfo.get("PID"), (int)orderInfo.get("total"), (String)orderInfo.get("trx_id"),(String)orderInfo.get("p_status"), LocalDate.now(), LocalTime.now());
		productService.updateOrder(order);
		
		
	}
	
	@GetMapping("/inventoryQ/{PID}/{QTY}")
	public String callInventoryQ(@PathVariable int PID,@PathVariable int QTY) {
		
		Map<String, Object> data=new HashMap<String, Object>();
		
		data.put("PID", PID);
		data.put("QTY", QTY);
		
		rt.convertAndSend("InventoryQ",data);
		
		
		
		return " Data written to InventoryQ";
	}
	

}
