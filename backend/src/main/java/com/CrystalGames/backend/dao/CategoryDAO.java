package com.CrystalGames.backend.dao;

import java.util.List;



import com.CrystalGames.backend.dto.Category;


public interface CategoryDAO {
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);   // to add category to hibernate
	boolean update(Category category);
	boolean delete(Category category);
	
	

}
