package com.ecart.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecart.dao.EcartDaoImpl;
import com.ecart.modal.Product;

public class EcartUtility {

	public void addCategory() {
		
		List<String> products = new ArrayList<>();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Category Name");
		String category=sc.next();
		System.out.println("Enter Category ID");
		int catId=sc.nextInt();
		
		Product product = new Product();
		product.setCat_id(catId);
		product.setCat_title(category);
		EcartDaoImpl el= new EcartDaoImpl();
		el.addNewCategory(product);
		
		
		
		
	}
	
public void addBrand() {
		
		List<String> products = new ArrayList<>();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Brand Name");
		String brand=sc.next();
		System.out.println("Enter Brand ID");
		int bId=sc.nextInt();
		
		Product product = new Product();
		product.setBrand_id(bId);
		product.setBrand_title(brand);
		EcartDaoImpl el= new EcartDaoImpl();
		el.addNewBrand(product);
		
		
		
		
	}

public void allOrdersofUser() {
	
	List<String> products = new ArrayList<>();
	
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter User First Name to show orders");
	String name=sc.next();
	
	
	
	Product product = new Product();
	product.setFirst_name(name);
	
	System.out.println(product);
	
	EcartDaoImpl el= new EcartDaoImpl();
	el.allOrdersofUser(product).forEach(System.out::println);	
	
}


public void clearCallcartUtility() {
	
	
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter User useid to clear cart data");
	String userid=sc.next();
	EcartDaoImpl el= new EcartDaoImpl();
	el.clearCallcart(userid);
	
}
}
