package com.ecart.main;

import java.util.Scanner;

import com.ecart.dao.EcartDaoImpl;
import com.ecart.utility.EcartUtility;



public class ecart {
	
	public void mainMenu() {
		System.out.println("===========================================");
		System.out.println("============  MENU ==============");
		System.out.println("===========================================");
		System.out.println("1 - List all brand names");
		System.out.println("2 - List all categories ");
		System.out.println("3 - List all products having brand name 'Samsung'");
		System.out.println("4 - List all Electronic products");
		System.out.println("5 - List all orders of a user");
		System.out.println("6 - Add new Category'");
		System.out.println("7 - Add new Brand");
		System.out.println("8 - Delete a single product item  in a cart of a specified user");
		System.out.println("9 - Clear all items in a cart of a user");
		
		System.out.println("x - Exit");
		System.out.println("===========================================");
		System.out.println("Please enter your option:");
		
		EcartDaoImpl el= new EcartDaoImpl();
		EcartUtility eu= new EcartUtility();
		
		
		Scanner sc=new Scanner(System.in);
		String ch= sc.nextLine();
		
		switch(ch) {
		
		case "1":
			System.out.println("---List all brand names--");
			System.out.println(" Brands ");
			System.out.println("-------------------");
			el.allBrands().forEach(System.out::println);
			
			break;
			
		case "2":
			System.out.println("---List all categories---");
			System.out.println(" Categories ");
			System.out.println("-------------------");
			el.allCategories().forEach(System.out::println);
			
			break;
			
			
		case "3":
			System.out.println("---List all products having brand name 'Samsung'--");
			System.out.println(" All Samsung Brand Product ");
			System.out.println("-------------------");
			el.allSamsungProduct().forEach(System.out::println);
			el.allBrands().forEach(System.out::println);
			
			break;
			
		case "4":
			System.out.println("---List all Electronic products---");
			System.out.println(" All  Electronic Product ");
			System.out.println("-------------------");
			el.allElectonicsProduct().forEach(System.out::println);
			
			break;
			
			
		case "5":
			System.out.println("--- List all orders of a user--");
			System.out.println(" All orders ");
			System.out.println("-------------------");
			eu.allOrdersofUser();
			
			break;
			
		case "6":
			System.out.println("---Add new Category---");
			eu.addCategory();
			
			break;
			
		case "7":
			System.out.println("---Add new Brand---");
			eu.addBrand();
			
			break;
			
		case "8":
			System.out.println("---Clear all items in a cart of a user---");
			eu.clearCallcartUtility();
			
			
			break;
			
		case "9":
			System.out.println("---Clear all items in a cart of a user---");
			eu.clearCallcartUtility();
			
			
			break;
			
		case "x":
			System.out.println(" Quit");
			System.exit(0);
			break;	
			
		default:   
            System.out.println("Please Enter coorect input");  	
		
		
		
		}
		
		

	}


}
