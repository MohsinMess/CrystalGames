package com.CrystalGames.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CrystalGames.backend.dao.CategoryDAO;
import com.CrystalGames.backend.dto.Category;


@Repository("categoryDAO") 	
@Transactional			// To enable DB transaction
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="FROM Category WHERE active=:active";  		//Category sould be the name of class and not as in DB
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	// Getting a single category based on id
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	public boolean add(Category category)
	{
		try {
		sessionFactory.getCurrentSession().persist(category);    // To push new category to DB
		return true; 
		}
		catch(Exception ex) 
		{
			ex.printStackTrace(); 
		return false;}
	}
	
	// Update a single category
	@Override
	public boolean update(Category category) {
		
		try {
			sessionFactory.getCurrentSession().update(category); return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;}
		
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false); 			// Deactivates Category
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch(Exception ex) {ex.printStackTrace(); return false;}
		
	}

}
