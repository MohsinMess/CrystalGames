package com.CrystalGames.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Product get(int id)
	{
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}
	
	public List<Product> list()
	{
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}
	
	public boolean add(Product product)
	{
		try
		{	
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) {ex.printStackTrace(); return false;}
	}
	
	public boolean update(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().update(product); 
			return true;
		}
		catch(Exception ex) {ex.printStackTrace(); return false;}
	}
	
	public boolean delete(Product product)
	{
		try
		{
			product.setActive(false);
			return this.update(product);
		}
		catch(Exception ex) {ex.printStackTrace(); return false;}
	}

	@Override
	public List<Product> ListActiveProducts() {
		String selectActiveProducts= "FROM Product WHERE active= :Active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("Active",true)
				.getResultList();
	}

	@Override
	public List<Product> ListActiveProductsByCategory(int categoryId) {
		String selecctActiveProductsByCategory="From Product WHERE active=:active AND categoryID=:CategoryId";
		return sessionFactory.getCurrentSession().createQuery(selecctActiveProductsByCategory,Product.class).setParameter("active",true)
				.setParameter("CategoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> ListLatestActiveProducts(int count) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active =: Active ORDER by id",Product.class)
				.setParameter("Active",true).setFirstResult(0).setMaxResults(count).getResultList();
	}
}









