package com.xor.ecartMain;


import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xor.ecart.config.AppConfig;
import com.xor.ecart.service.ProductService;
import com.xor.ecart.service.ProductServiceImpl;
import com.xor.ecartDao.ProductDaoImpl;
import com.xor.ecartModel.Brand;
import com.xor.ecartModel.Category;
import com.xor.ecartModel.Product;




public class ecartTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductService prodServiceImpl = ac.getBean(ProductServiceImpl.class);
		
		System.out.println("Welcome to Eshop");
		
	
		
		while (true) {
			System.out.println("-------------------------------------------");
			System.out.println("1.List all products with category name and brand names");
			System.out.println("2.List all brand names");
			System.out.println("3.List all categories ");
			System.out.println("4.List all products by brand ");
			System.out.println("5.List all Electronic products ");
			System.out.println("6.List all products and their total price available in  cart of a user ");
			System.out.println("7.List all orders of a user ");
			System.out.println("8.Add a product to the products table with existing category and brand ");
			System.out.println("9.Add new Category ");
			System.out.println("10.Add new Brand ");
			System.out.println("11.Clear all items in a cart of a user ");
			System.out.println("12.Delete a single product item  in a cart of a specified user");
			System.out.println("13.List all Products along with Brands and Categories filter by Product name.");
			System.out.println("Enter 0 to quit");
			
			Scanner sc = new Scanner(System.in);
			String inp = sc.nextLine();
			
			switch(inp){
				
			case "1":
				System.out.println("===List all products with category name and brand names===");
				System.out.println("-------------------------------------------");
				List<Product> prods = prodServiceImpl.listAllProductByBrandCat();
				for(Product ps : prods ) {
					System.out.println("Product name :"+ps.getProductName()+" |Product Category :"+ps.getCategory().getCategoryTitle()+" |Brand Name :"+ps.getBrand().getBrandTitle());
				}
				break;
		
			
			case "2":
				System.out.println("===List all brand names===");
				System.out.println("-------------------------------------------");
				prodServiceImpl.listAllBrand().forEach(System.out::println);
				break;
			
			case "3":
				System.out.println("===List all categories===");
				System.out.println("-------------------------------------------");
				prodServiceImpl.listAllCategory().forEach(System.out::println);
				break;
			
			case "4":
				System.out.println("Enter brand Name :");
				 sc = new Scanner(System.in);
				String brand = sc.nextLine();
				System.out.println("==List all products by brand "+brand+"===");
				System.out.println("-------------------------------------------");
				prodServiceImpl.findProductBybrand(brand).forEach(System.out::println);
				break;
				
			
			case "5":
				System.out.println("===List all Electronic products===");
				System.out.println("-------------------------------------------");
				List<Product> pd = prodServiceImpl.listAllElectronicsProds();
				 for (Product prod : pd)
				    {
				        System.out.println(prod.getProductName());
				        
				    }
				
				break;
				
			case "6":	
				
				System.out.println("Enter User first name :");
				sc = new Scanner(System.in);
				String name = sc.nextLine();
				System.out.println("List of products and their price available in cart of "+name);
				System.out.println("-------------------------------------------");
				prodServiceImpl.CartItemWithPrice(name).forEach(System.out::println);
				break;
				
			case "7":
				System.out.println("Enter User first name :");
				sc = new Scanner(System.in);
				String user = sc.nextLine();
				System.out.println("List of orders of "+user);
				System.out.println("-------------------------------------------");
				prodServiceImpl.listAllOrders(user).forEach(System.out::println);
				break;
				
			case "8":
				Product p = new Product();
				
				System.out.println("Enter Product Id :");
				sc = new Scanner(System.in);
				p.setProductId(sc.nextInt());
				System.out.println("Enter category Id :");
				sc = new Scanner(System.in);
				p.setCategory(new Category(sc.nextInt()));
				System.out.println("Enter brand Id :");
				sc = new Scanner(System.in);
				p.setBrand(new Brand(sc.nextInt()));
				System.out.println("Enter product name :");
				sc = new Scanner(System.in);
				p.setProductName(sc.nextLine());
				System.out.println("Enter product price :");
				sc = new Scanner(System.in);
				p.setPrice(sc.nextDouble());
				System.out.println("Enter product quantity :");
				sc = new Scanner(System.in);
				p.setQuantity(sc.nextInt());
				System.out.println("Enter product description :");
				sc = new Scanner(System.in);
				p.setDescription(sc.nextLine());
				System.out.println("Enter product Image Path :");
				sc = new Scanner(System.in);
				p.setImagePath(sc.nextLine());
				System.out.println("Enter product Keywords :");
				sc = new Scanner(System.in);
				p.setKeywords(sc.nextLine());
				prodServiceImpl.addNewProduct(p);
				break;
				
				
			case "9":
				Category ct = new Category();
				System.out.println("Enter category Id :");
				sc = new Scanner(System.in);
				ct.setCategoryId(sc.nextInt());
				
				System.out.println("Enter category name :");
				sc = new Scanner(System.in);
				ct.setCategoryTitle(sc.nextLine());
				prodServiceImpl.addNewCategory(ct);
				break;
				
				
			case "10":
				Brand br = new Brand();
				System.out.println("Enter Brand Id :");
				sc = new Scanner(System.in);
				br.setBrandId(sc.nextInt());
				System.out.println("Enter Brand title :");
				sc = new Scanner(System.in);
				br.setBrandTitle(sc.nextLine());
				prodServiceImpl.addNewBrand(br);
				break;
				
			case "11":
				
				System.out.println("Enter user first name :");
				sc = new Scanner(System.in);
				String usrname = sc.nextLine();
				prodServiceImpl.clearCartItems(usrname);
				break;
				
			case "12":
				System.out.println("Enter user first name :");
				sc = new Scanner(System.in);
				String na = sc.nextLine();
				System.out.println("Enter Product Id :");
				int id = sc.nextInt();
				prodServiceImpl.deleteCartItem(na,id);
				break;
			
			case "13":
				System.out.println("Enter keyword to list products :");
				String Key = sc.nextLine();
				prodServiceImpl.ListAllProductByKey(Key).forEach(System.out::println);
				break;
				
			case "0":
				System.out.println("Thanks for visiting us");
				System.exit(0);
				break;	
				
			default:   
	            System.out.println("Please Enter correct input");
				
			}
			
		}
		
		
		

	}

	

}
