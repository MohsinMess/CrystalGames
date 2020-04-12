package com.CrystalGames.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productdao;
	
	@RequestMapping("/all/products")
	@ResponseBody						// Returns data in JSON format
	public List<Product> getAllProducts()
	{
		return productdao.ListActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody						// Returns data in JSON format
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productdao.ListActiveProductsByCategory(id);
	}
	

}
