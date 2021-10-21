package com.xor.ecartUtils;

public class DbQueries {
	
	
	
	public static final String LIST_ALL_PRODUCTS="select * from products";
	
	public static final String ADD_NEW_PRODUCT="insert into products values(?,?,?,?,?,?,?,?,?)";
	
	public static final String LIST_ALL_BRANDS = "select * from brands";
	
	public static final String LIST_ALL_CATEGORIES = "select * from categories";
	
	public static final String LIST_PRODUCT_BY_BRAND_CATEGORY ="select  p.product_title,c.cat_title,b.brand_title from products p inner join categories\r\n"
			+ "					c on p.product_cat=c.cat_id inner join brands  b on p.product_brand = b.brand_id";
	
	
	public static final String LIST_PRODUCT_BY_KEY = "select  p.product_title,c.cat_title,b.brand_title from products p inner join categories\r\n"
			+ "c on p.product_cat=c.cat_id inner join brands  b on p.product_brand = b.brand_id where p.product_title like ? ";
	
	public static final String LIST_PRODUCT_BY_BRAND = "select p.product_title,p.product_desc,p.product_price,p.product_qty from products p inner join  brands b on p.product_brand=b.brand_id where b.brand_title = ? ";
	
	public static final String LIST_ALL_ELECTRONICS_PRODUCT ="select product_title from products where product_cat IN (select cat_id from categories where cat_title IN ('Home Appliances','Mobiles'))";
	
	public static final String LIST_ALL_ORDER_BY_USER = "select p.product_title,p.product_price,p.product_desc , o.p_status\r\n"
			+ "					from products p inner join  orders o on  p.product_id=o.product_id  inner join user_info u \r\n"
			+ "					on u.user_id=o.user_id where u.first_name=?";
	
	
	public static final String ADD_NEW_BRAND = "insert into brands values(?,?)";
	
	public static final String ADD_NEW_CATEGORY = "insert into categories values(?,?)";
	
	public static final String CLEAR_CART_BY_USER = "delete c from  cart c inner join user_info u on c.user_id = u.user_id where  u.user_id = ? ";

	public static final String DELETE_ITEM_FROM_CART_BY_USER = "delete c from  cart c inner join user_info u on c.user_id = u.user_id where  u.user_id = ? and c.p_id = ? ";
	
	public static final String CART_PRODUCT_WITH_PRICE_BY_USER = "select p.product_title,p.product_price,c.qty from products p inner join cart c on p.product_id = c.p_id inner join user_info u on c.user_id = u.user_id where u.first_name = ?";
}
