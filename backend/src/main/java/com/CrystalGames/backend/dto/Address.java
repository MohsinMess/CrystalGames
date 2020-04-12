package com.CrystalGames.backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="address_line_one")
	private String addresslineone;
	@Column(name="address_line_two")
	private String addresslinetwo;
	private String city;
	private String state;
	private String country;
	@Column(name="postal_code")
	private String postalcode;
	private boolean shipping;
	private boolean billing;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getAddresslineone() {
		return addresslineone;
	}
	public void setAddresslineone(String addresslineone) {
		this.addresslineone = addresslineone;
	}
	public String getAddresslinetwo() {
		return addresslinetwo;
	}
	public void setAddresslinetwo(String addresslinetwo) {
		this.addresslinetwo = addresslinetwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [Id=" + Id + ", addresslineone=" + addresslineone + ", addresslinetwo="
				+ addresslinetwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalcode="
				+ postalcode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	

}
