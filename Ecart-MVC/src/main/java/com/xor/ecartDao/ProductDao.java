package com.xor.ecartDao;

import java.util.List;

import com.xor.ecartModel.Brand;
import com.xor.ecartModel.Cart;
import com.xor.ecartModel.Category;
import com.xor.ecartModel.Order;
import com.xor.ecartModel.Product;

public interface ProductDao {

	Brand addNewBrand(Brand brand);

	Category addNewCategory(Category category);
	
	Product addNewProduct(Product product);

	List<Product> listAllProduct();

	List<Brand> listAllBrand();

	List<Category> listAllCategory();

	List<Product> findProductBybrand(String productName);

	List<Product> listAllOrders(String user);

	List<Product> listAllProductByBrandCat();

	List<Product> listAllElectronicsProds();

	List<Product> CartItemWithPrice(String user);

	void clearCartItems(String user);

	void deleteCartItem(String user,int prodId);
	
	List<Product> ListAllProductByKey(String key);
}
