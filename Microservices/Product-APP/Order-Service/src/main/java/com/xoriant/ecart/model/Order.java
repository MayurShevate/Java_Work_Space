package com.xoriant.ecart.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {

	private int  order_id;
	private int  user_id;
	private int  product_id;
	private int total;
	private String trx_id;
	private String p_status;
	private LocalDate date;
	private LocalTime time;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(int order_id, int user_id, int product_id, int total, String trx_id, String p_status, LocalDate date,
			LocalTime time) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.total = total;
		this.trx_id = trx_id;
		this.p_status = p_status;
		this.date = date;
		this.time = time;
	}




	public int getOrder_id() {
		return order_id;
	}



	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public String getTrx_id() {
		return trx_id;
	}



	public void setTrx_id(String trx_id) {
		this.trx_id = trx_id;
	}



	public String getP_status() {
		return p_status;
	}



	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	




	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalTime getTime() {
		return time;
	}



	public void setTime(LocalTime time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", product_id=" + product_id + ", total="
				+ total + ", trx_id=" + trx_id + ", p_status=" + p_status + ", date=" + date + ", time=" + time + "]";
	}



	
	
	
	
	
	
}
