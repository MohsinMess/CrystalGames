package com.CrystalGames.backend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@NotBlank(message="Please enter product name")
	private String name;
	@NotBlank(message="Please enter brand name")
	private String brand;
	@JsonIgnore
	@NotBlank(message="Please enter description")
	private String description;
	@Column(name="unit_price")
	@Min(value=1 ,message="The price cannot be less than 1")
	private double unit_price;
	private int quantity;
	@Column(name="is_active")
	@JsonIgnore
	private boolean active;
	@Column(name="category_id")
	@JsonIgnore
	private int categoryID;
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierID;
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	// Default constructor to set code of the product automatically
	public Product()
	{
		this.code= "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unit_price=" + unit_price + ", quantity=" + quantity + ", active=" + active
				+ ", categoryID=" + categoryID + ", supplierID=" + supplierID + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	
	

}
