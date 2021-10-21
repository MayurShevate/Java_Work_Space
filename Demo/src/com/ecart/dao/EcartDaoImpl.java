package com.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecart.config.DBConfig;
import com.ecart.modal.Product;
import com.ecart.modal.ProductCat;



public class EcartDaoImpl {
	
	
	public List<String> allBrands() {

		ArrayList<String> bl=new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select brand_title from brands";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				
//				product.setBrand_title(rs.getString("brand_title"));

				bl.add(rs.getString("brand_title"));
//				products.add(product);
			}

		} catch (Exception e) {
			System.out.println("failed ----> " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return bl;
	}

	public List<String> allCategories () {
		
		ArrayList<String> bl=new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select cat_title from categories";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				
//				product.setBrand_title(rs.getString("brand_title"));

				bl.add(rs.getString("cat_title"));
//				products.add(product);
			}

		} catch (Exception e) {
			System.out.println("failed ----> " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return bl;
	
	}
	
	
public List<String> allSamsungProduct () {
		
		ArrayList<String> bl=new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select product_title from products where product_brand=2";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				
//				product.setBrand_title(rs.getString("brand_title"));

				bl.add(rs.getString("product_title"));
//				products.add(product);
			}

		} catch (Exception e) {
			System.out.println("failed ----> " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return bl;
	
	}
	

public List<String> allElectonicsProduct () {
	
	ArrayList<String> bl=new ArrayList<>();

	try {
		Connection con = DBConfig.getConnection();
		Statement stmt = con.createStatement();
		String q1 = "select product_title from products where product_cat=13";

		ResultSet rs = stmt.executeQuery(q1);

		while (rs.next()) {
			
//			product.setBrand_title(rs.getString("brand_title"));

			bl.add(rs.getString("product_title"));
//			products.add(product);
		}

		int blSize=bl.size();
		if(blSize==0) {
			
			bl.add("No Records Found");
		}
	} catch (Exception e) {
		System.out.println("failed ----> " + e);
		e.printStackTrace();
	} finally {
		DBConfig.closeConnection();
	}

	return bl;

}



public void addNewCategory(Product product) {
	
		try {
			Connection con = DBConfig.getConnection();
			String q1 = "insert into categories values(?,?)";
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setInt(1, product.getCat_id());
			ps.setString(2, product.getCat_title());
			

			int res = ps.executeUpdate();
			if (res != 0) {
				System.out.println(product.getCat_title() + "  Category has been added ");
			} else {
				System.out.println("Category not saved");
			}

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection();
		}


}
public void addNewBrand(Product product) {
	
	try {
		Connection con = DBConfig.getConnection();
		String q1 = "insert into brands values(?,?)";
		PreparedStatement ps = con.prepareStatement(q1);
		ps.setInt(1, product.getBrand_id());
		ps.setString(2, product.getBrand_title());
		

		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println(product.getCat_title() + " New Brand added ");
		} else {
			System.out.println("Record not saved..");
		}

	} catch (Exception e) {
		System.out.println("failed due to " + e);
		e.printStackTrace();
	}finally {
		DBConfig.closeConnection();
	}
}
	
	public List<ProductCat> allOrdersofUser(Product product) {

		List<ProductCat> products = new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();
			
			Statement stmt = con.createStatement();
			String q1 = "select p.product_title,p.product_price,p.product_desc\r\n"
					+ "from products p inner join  orders o on  p.product_id=o.product_id  inner join user_info u \r\n"
					+ "on u.user_id=o.user_id where u.first_name='" + product.getFirst_name() + "'";
			
			
			ResultSet rs = stmt.executeQuery(q1);
//			System.out.println(q1);
			while (rs.next()) {
				
				ProductCat p1 = new ProductCat();
				p1.setProduct_title(rs.getString("product_title"));
				p1.setProduct_price(rs.getInt(2));
				p1.setProduct_desc(rs.getString("product_desc"));
				
				products.add(p1);
			}

		} catch (Exception e) {
			System.out.println("failed ----> " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return products;
	}
	
	
	public  void clearCallcart(String userid) {
		
		try {
			Connection con = DBConfig.getConnection();
			String q1 = "delete from   cart where user_id= ?";
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setString(1, userid);
			int res = ps.executeUpdate();
			if (res != 0) {
				System.out.println( " Clear all items in a cart of a user "+userid);
			} else {
				System.out.println("Items Not found");
			}

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection();
		}
		
		
	}

}
























