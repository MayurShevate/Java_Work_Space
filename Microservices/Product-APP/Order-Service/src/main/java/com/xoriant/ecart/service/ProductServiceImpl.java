package com.xoriant.ecart.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Order;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;

	@Override
	public Order updateOrder(Order order) {
		return prodDao.updateOrder(order);
	}

	// Update Inventory details


}
