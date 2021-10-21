package com.ecart.modal;

public class Product {
	
	private int brand_id;
	private String brand_title;
	private int cat_id;
	private String cat_title; 
	private String first_name;
	private String product_title;
	private  String product_price;
	private String product_desc;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int brand_id, String brand_title) {
		
		this.brand_id = brand_id;
		this.brand_title = brand_title;
	}
	
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
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
	
	
	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_title() {
		return cat_title;
	}

	public void setCat_title(String cat_title) {
		this.cat_title = cat_title;
	}

	@Override
	public String toString() {
		return "Product [brand_id=" + brand_id + ", brand_title=" + brand_title + ", cat_id=" + cat_id + ", cat_title="
				+ cat_title + ", first_name=" + first_name + ", product_title=" + product_title + ", product_price="
				+ product_price + ", product_desc=" + product_desc + "]";
	}


	
	

}
