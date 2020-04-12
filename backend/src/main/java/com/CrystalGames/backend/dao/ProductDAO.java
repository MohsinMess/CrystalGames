package com.CrystalGames.backend.dao;

import java.util.List;

import com.CrystalGames.backend.dto.Product;

public interface ProductDAO 
{
	Product get(int id);
	List<Product> list();
	boolean add(Product product);   // to add category to hibernate
	boolean update(Product product);
	boolean delete(Product product);
	
	// Bussiness Methods
	List<Product> ListActiveProducts();
	List<Product> ListActiveProductsByCategory(int categoryId);
	List<Product> ListLatestActiveProducts(int count);
	

}
