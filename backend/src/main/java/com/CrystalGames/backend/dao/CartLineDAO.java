package com.CrystalGames.backend.dao;

import java.util.List;

import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.CartLine;

public interface CartLineDAO {
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// business methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	
	boolean updateCart(Cart cart);

}
