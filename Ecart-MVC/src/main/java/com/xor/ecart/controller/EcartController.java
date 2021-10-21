package com.xor.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xor.ecart.service.ProductService;
import com.xor.ecartModel.Product;

@Controller
public class EcartController {

	@Autowired
	private ProductService ps;

//	@Autowired
//	private Product prod; 

	// load welcome page

	@GetMapping
	public String welcome() {
		return "index";
	}

	// load form
	@RequestMapping("/loadForm")
	public String loadProductFrom() {
		return "product-form";
	}

	@RequestMapping("/findAll")
	public String findAllProducts(ModelMap model) {

		List<Product> products = ps.listAllProduct();

		model.addAttribute("prods", products);

		return "products";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Product") Product product, Model model) {
		Product prods = ps.addNewProduct(product);

		if (prods != null) {
			model.addAttribute("msg", product.getProductName() + " has been Added successfully");

		} else {

			model.addAttribute("msg", "There is some issue");
		}

		System.out.println("Product has been Added successfully" + product);

		return "ThankYou";
	}

}
