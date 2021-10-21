package com.xor.ecartDao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xor.ecartModel.Brand;
import com.xor.ecartModel.Cart;
import com.xor.ecartModel.Category;
import com.xor.ecartModel.Order;
import com.xor.ecartModel.Product;
import com.xor.ecartUtils.DbQueries;




@Repository
public class ProductDaoImpl implements ProductDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Brand addNewBrand(Brand brand) {
		
		int res = jdbcTemplate.update(DbQueries.ADD_NEW_BRAND, brand.getBrandId(),brand.getBrandTitle());

		if (res != 0) {
			return brand;
		}
		System.out.println("Brand has been added successfully");
		
		return null;
	}

	@Override
	public Category addNewCategory(Category category) {
		int res = jdbcTemplate.update(DbQueries.ADD_NEW_CATEGORY, category.getCategoryId(),category.getCategoryTitle());

		if (res != 0) {
			return category;
		}
		
		System.out.println("Category has been added successfully");
		return null;
	}



	@Override
	public List<Product> listAllProduct() {
		return jdbcTemplate.query(DbQueries.LIST_ALL_PRODUCTS, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductId(rs.getInt("product_id"));
				prod.setProductName(rs.getString("product_title"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setImagePath(rs.getString("product_image"));
				prod.setKeywords(rs.getString("product_keywords"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("product_qty"));
				prods.add(prod);
			}
			return prods;
		});

	}
	
	

	@Override
	public List<Brand> listAllBrand() {
		return jdbcTemplate.query(DbQueries.LIST_ALL_BRANDS, (ResultSet rs) -> {
			List<Brand> brs = new ArrayList<>();
			while (rs.next()) {
				Brand br = new Brand();
				br.setBrandId(rs.getInt("brand_id"));
				br.setBrandTitle(rs.getString("brand_title"));
				brs.add(br);
			}
			return brs;
		});
		
	}

	@Override
	public List<Category> listAllCategory() {
		return jdbcTemplate.query(DbQueries.LIST_ALL_CATEGORIES, (ResultSet rs) -> {
			List<Category> cts = new ArrayList<>();
			while (rs.next()) {
				Category ct = new Category();
				ct.setCategoryId(rs.getInt("cat_id"));
				ct.setCategoryTitle(rs.getString("cat_title"));
		
				cts.add(ct);
			}
			return cts;
		});
	
	}

	@Override
	public List<Product> findProductBybrand(String brandName) {
		return jdbcTemplate.query(DbQueries.LIST_PRODUCT_BY_BRAND, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			
			while (rs.next()) {
				Product prod  = new Product();
				prod.setProductName(rs.getString("product_title"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("product_qty"));
				prods.add(prod);

			}
			return prods;
		}, brandName);
	
	}


	@Override
	public List<Product> listAllOrders(String user) {
		return jdbcTemplate.query(DbQueries.LIST_ALL_ORDER_BY_USER, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			Product prod = null;
			if (rs.next()) {
				prod = new Product();
				prod.setProductName(rs.getString("product_title"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setDescription(rs.getString("product_desc"));
				prod.setStatus(rs.getString("p_status"));
				prods.add(prod);

			}
			return prods;
		}, user);
	}

	@Override
	public void clearCartItems(String user) {
		int res =  jdbcTemplate.update(DbQueries.CLEAR_CART_BY_USER,user);
		
	}
	@Override
	public void deleteCartItem(String user,int prodId) {
		jdbcTemplate.update(DbQueries.DELETE_ITEM_FROM_CART_BY_USER,user,prodId);
		
	}

	@Override
	public List<Product> listAllProductByBrandCat() {
		return jdbcTemplate.query(DbQueries.LIST_PRODUCT_BY_BRAND_CATEGORY, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductName(rs.getString("product_title"));
				prod.setCategory(new Category(rs.getString("cat_title")));
				prod.setBrand(new Brand(rs.getString("brand_title")));
				prods.add(prod);
			}
			return prods;
		});
	}

	@Override
	public List<Product> listAllElectronicsProds() {
		return jdbcTemplate.query(DbQueries.LIST_ALL_ELECTRONICS_PRODUCT, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductName(rs.getString("product_title"));
				prods.add(prod);
			}
			return prods;
		});

	}

	@Override
	public List<Product> CartItemWithPrice(String user) {
		return jdbcTemplate.query(DbQueries.CART_PRODUCT_WITH_PRICE_BY_USER, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductName(rs.getString("product_title"));
				prod.setPrice(rs.getDouble("product_price"));
				prod.setQuantity(rs.getInt("qty"));
				prods.add(prod);
			}
			return prods;
		},user);
	}

	@Override
	public Product addNewProduct(Product product) {
		int res = jdbcTemplate.update(DbQueries.ADD_NEW_PRODUCT, product.getProductId(), product.getCategory().getCategoryId(),
				product.getBrand().getBrandId(), product.getProductName(), product.getPrice(), product.getQuantity(),
				product.getDescription(), product.getImagePath(), product.getKeywords());

		if (res != 0) {
			return product;
		}
		
		System.out.println("Product has been added successfully");
		
		return null;
		
	}

	@Override
	public List<Product> ListAllProductByKey(String key) {
		String Keylike = "%" +key +"%";
		return jdbcTemplate.query(DbQueries.LIST_PRODUCT_BY_KEY, (ResultSet rs) -> {
			List<Product> prods = new ArrayList<>();
			while (rs.next()) {
				Product prod = new Product();
				prod.setProductName(rs.getString("product_title"));
				prod.setCategory(new Category(rs.getString("cat_title")));
				prod.setBrand(new Brand(rs.getString("brand_title")));
				prods.add(prod);
			}
			return prods;
		},Keylike);
	
	}
	
	

}
