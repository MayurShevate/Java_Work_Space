package com.xoriant.ecart.dao;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.dao.utils.DBQueries;
import com.xoriant.ecart.model.Order;


@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Order updateOrder(Order order) {
		int res =  jdbcTemplate.update(DBQueries.UPDATE_ORDER,order.getOrder_id(),order.getUser_id(),order.getProduct_id(),order.getTotal(),order.getTrx_id(),order.getTrx_id(),order.getP_status());
		if (res != 0) {
			return order;
		}
		return null;
	}

	

 
	

}
