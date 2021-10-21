package com.xor.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xor.ecartDao.ProductDao;
import com.xor.ecartDao.ProductDaoImpl;
import com.xor.ecartModel.Brand;
import com.xor.ecartModel.Category;
import com.xor.ecartModel.Product;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDaoImpl productDao;

	@Override
	public Brand addNewBrand(Brand brand) {
		return productDao.addNewBrand(brand);
	}

	@Override
	public Category addNewCategory(Category category) {
		
		return productDao.addNewCategory(category);
	}

	@Override
	public Product addNewProduct(Product product) {
		
		return productDao.addNewProduct(product);
	}

	@Override
	public List<Product> listAllProduct() {
		
		return productDao.listAllProduct();
	}

	@Override
	public List<Brand> listAllBrand() {
	
		return productDao.listAllBrand();
	}

	@Override
	public List<Category> listAllCategory() {
		
		return productDao.listAllCategory();
	}

	@Override
	public List<Product> findProductBybrand(String productName) {
	
		return productDao.findProductBybrand(productName);
	}

	@Override
	public List<Product> listAllOrders(String user) {
	
		return productDao.listAllOrders(user);
	}

	@Override
	public List<Product> listAllProductByBrandCat() {
	
		return productDao.listAllProductByBrandCat();
	}

	@Override
	public List<Product> listAllElectronicsProds() {
		
		return productDao.listAllElectronicsProds();
	}

	@Override
	public List<Product> CartItemWithPrice(String user) {
	
		return productDao.CartItemWithPrice(user);
	}

	@Override
	public void clearCartItems(String user) {
		productDao.clearCartItems(user);
		
	}

	@Override
	public void deleteCartItem(String user, int prodId) {
		productDao.deleteCartItem(user, prodId);
		
	}

	@Override
	public List<Product> ListAllProductByKey(String key) {
		
		return productDao.ListAllProductByKey(key);
	}
	
	

}
