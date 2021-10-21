package com.xoriant.ecart.model;

public class Brand {
	
	private int brand_id;
	private String brand_title;
	
	
	public Brand(int brand_id, String brand_title) {
		super();
		this.brand_id = brand_id;
		this.brand_title = brand_title;
	}


	public int getBrand_id() {
		return brand_id;
	}


	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}


	public String getBrand_title() {
		return brand_title;
	}


	public void setBrand_title(String brand_title) {
		this.brand_title = brand_title;
	}


	@Override
	public String toString() {
		return "Brand [brand_id=" + brand_id + ", brand_title=" + brand_title + "]";
	}
	
	
	
	
	

}
