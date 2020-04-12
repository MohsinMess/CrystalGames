package com.CrystalGames.backend.dao;

import java.util.List;

import com.CrystalGames.backend.dto.Address;
import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.User;

public interface UserDAO 
{
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	
	List<Address> listShippingAddresses(User user);
	
	boolean updateCart(Cart cart);
	

}