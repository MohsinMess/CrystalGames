package com.CrystalGames.frontend.model;

import java.io.Serializable;

import com.CrystalGames.backend.dto.Cart;


public class UserModel implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String  fulName;
	private String email;
	private String role;
	private Cart cart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFulName() {
		return fulName;
	}
	public void setFulName(String fulName) {
		this.fulName = fulName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fulName=" + fulName + ", email=" + email + ", role=" + role + ", cart=" + cart
				+ "]";
	}
	
	
}
