package com.CrystalGames.backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	@Column(name="grand_total")
	private double grandtotal;
	
	@Column(name="cart_lines")
	private int cartlines;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public int getCartlines() {
		return cartlines;
	}
	public void setCartlines(int cartlines) {
		this.cartlines = cartlines;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", grandtotal=" + grandtotal + ", cartlines=" + cartlines
				+ "]";
	}
	
	

}
