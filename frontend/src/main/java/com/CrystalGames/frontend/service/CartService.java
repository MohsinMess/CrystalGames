package com.CrystalGames.frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrystalGames.backend.dao.CartLineDAO;
import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.CartLine;
import com.CrystalGames.frontend.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines(){
		return cartLineDAO.list(getCart().getId());
	}
	
	
	
}






