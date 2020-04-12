package com.CrystalGames.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CrystalGames.backend.dao.CartLineDAO;
import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public CartLine get(int id) {
		return sessionfactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().delete(cartLine);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query= "FROM CartLine WHERE cartId= :cartId";
		return sessionfactory.getCurrentSession().createQuery(query,CartLine.class).setParameter("cartId",cartId).getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query= "FROM CartLine WHERE cartId= :cartId AND available = :available";
		return sessionfactory.getCurrentSession().createQuery(query,CartLine.class)
				.setParameter("cartId",cartId)
				.setParameter("available",true)
				.getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query= "FROM CartLine WHERE cartId= :cartId AND product.id = :productId";
		try {
		return sessionfactory.getCurrentSession().createQuery(query,CartLine.class)
				.setParameter("cartId",cartId)
				.setParameter("productId",productId)
				.getSingleResult(); }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionfactory.getCurrentSession().persist(cart);
			return true;
		}
		catch(Exception ex) {
			ex.getStackTrace();
			return false;
		}
	}

}
