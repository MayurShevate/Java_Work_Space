package com.xoriant.main;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.model.Product;

public class testEcart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDao pt = new ProductDao();
	
		System.out.println("===========================================");
		System.out.println("1 -  List all products with category name and brand names");
		pt.GetProductData().forEach(System.out::println);
		
		System.out.println("===========================================");
		System.out.println("2 -  List all brand names");
		pt.getBrands().forEach(System.out::println);
		
		System.out.println("===========================================");
		System.out.println("2 -   List all categories ");
		pt.getCategories().forEach(System.out::println);
		
		System.out.println("===========================================");
		System.out.println("2 -   List all products having brand name 'Samsung' ");
		pt.getSamsungProduct().forEach(System.out::println);
		

		System.out.println("===========================================");
		System.out.println("2 - List all Electronic products ");
		pt.getElectonicsProduct().forEach(System.out::println);
		

		System.out.println("===========================================");
		System.out.println("2 - List all orders of a user ");
		Product p = new Product();
		p.setMobile("1234567899");
		pt.getAllOrders(p).forEach(System.out::println);
		
		
		
		System.out.println("===========================================");
		System.out.println("2 - Add new Category ");
		Product p2 = new Product();
		int count = 10;
		count++;
//		p2.setProduct_cat(count);
//		p2.setCat_title("New Category"+count);
		String title ="New Category"+count;
//		System.out.println(p2);
		pt.addCat(count,title);
		
		System.out.println("===========================================");
		System.out.println("2 - Clear all items in a cart of a user");
		pt.clearCart("1");
		


		

	}

}
