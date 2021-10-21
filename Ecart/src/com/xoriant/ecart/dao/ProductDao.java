package com.xoriant.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.utils.DBUtils;



public class ProductDao {







	public List<String> GetProductData() {

		ArrayList<String> p1=new ArrayList<>();

		try {
			Connection con = DBUtils.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select  p.product_title,c.cat_title,b.brand_title from ecart_demo.products p inner join ecart_demo.categories\r\n"
					+ "c on p.product_cat=c.cat_id inner join ecart_demo.brands  b on p.product_brand = b.brand_id";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				p1.add(rs.getString("product_title"));
				p1.add(rs.getString("cat_title"));
				p1.add(rs.getString("brand_title"));
				
			}

		} catch (Exception e) {
			System.out.println("Error ->" + e);
			e.printStackTrace();
		} finally {
//			DBUtils.closeConnection();
		}

		return p1;
	}
	
	
	
	
	public List<String> getBrands() {

		ArrayList<String> brands=new ArrayList<>();
		

		try {
			Connection con = DBUtils.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select brand_title from brands";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				brands.add(rs.getString("brand_title"));

			}

		} catch (Exception e) {
			System.out.println("Error ->" + e);
			e.printStackTrace();
		} finally {
//			DBUtils.closeConnection();
		}

		return brands;
	}
	
	
	public List<String> getCategories () {
		
		ArrayList<String> cat = new ArrayList<>();

		try {
			Connection con = DBUtils.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select cat_title from categories";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {

				cat.add(rs.getString("cat_title"));
			}

		} catch (Exception e) {
			System.out.println("Error ->" + e);
			e.printStackTrace();
		} finally {
//			DBUtils.closeConnection();
		}

		return cat;
	
	}
	
	
public List<String> getSamsungProduct () {
		
		ArrayList<String> sam =new ArrayList<>();

		try {
			Connection con = DBUtils.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select product_title from products where product_brand=2";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {


				sam.add(rs.getString("product_title"));

			}

		} catch (Exception e) {
			System.out.println("Error  -> " + e);
			e.printStackTrace();
		} finally {
//			DBUtils.closeConnection();
		}

		return sam;
	
	}


public List<String> getElectonicsProduct () {
	
	ArrayList<String> et = new ArrayList<>();

	try {
		Connection con = DBUtils.getConnection();
		Statement stmt = con.createStatement();
		String q1 = "select product_title from products where product_cat=13";

		ResultSet rs = stmt.executeQuery(q1);

		while (rs.next()) {
			et.add(rs.getString("product_title"));
		}


	} catch (Exception e) {
		System.out.println("Error  ---> " + e);
		e.printStackTrace();
	} finally {
//		DBUtils.closeConnection();
	}

	return et;

}



public void addCat(int count, String title) {
	
	try {
		Connection con = DBUtils.getConnection();
		String q1 = "insert into categories values(?,?)";
		PreparedStatement ps = con.prepareStatement(q1);
		ps.setInt(1,count);
		ps.setString(2, title);
		

		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println(title + " Category has been added ");
		} else {
			System.out.println("Category not saved.");
		}

	} catch (Exception e) {
		System.out.println("failed due to " + e);
		e.printStackTrace();
	}finally {
//		DBUtils.closeConnection();
	}


}


public void addBrand(Product product) {
	
	try {
		Connection con = DBUtils.getConnection();
		String q1 = "insert into brands values(?,?)";
		PreparedStatement ps = con.prepareStatement(q1);
		ps.setInt(1, product.getProduct_brand());
		ps.setString(2, product.getBrand_title());
		

		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println(product.getCat_title() + " New Brand has been added ");
		} else {
			System.out.println("Brand not saved.");
		}

	} catch (Exception e) {
		System.out.println("failed due to " + e);
		e.printStackTrace();
	}finally {
//		DBUtils.closeConnection();
	}
}


	
	
	
	public List<String> getAllOrders(Product product) {

		ArrayList<String> us =new ArrayList<>();

		try {
			Connection con = DBUtils.getConnection();
			
			Statement stmt = con.createStatement();
			String q1 = "select p.product_title,p.product_price,p.product_desc\r\n"
					+ "from products p inner join  orders o on  p.product_id=o.product_id  inner join user_info u \r\n"
					+ "on u.user_id=o.user_id where u.mobile='" + product.getMobile() + "'";
			
			
			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				
				us.add(rs.getString("product_title"));
				us.add(rs.getString("product_price"));
				us.add(rs.getString("product_desc"));
				
			}

		} catch (Exception e) {
			System.out.println("failed ----> " + e);
			e.printStackTrace();
		} finally {
//			DBUtils.closeConnection();
		}

		return us;
	}
	
	
	
	public  void clearCart(String userid) {
		
		try {
			Connection con = DBUtils.getConnection();
			String q1 = "delete from   cart where user_id= ?";
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setString(1, userid);
			int res = ps.executeUpdate();
			if (res != 0) {
				System.out.println( " Cart Cleared of  "+userid);
			} else {
				System.out.println("cart is empty");
			}

		} catch (Exception e) {
			System.out.println("Error-> " + e);
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection();
		}
		
		
	}

	// fetch Data from Product table using ResultSet interface - SCROLL - UPDATABLE
	// - DEMO
	

}
