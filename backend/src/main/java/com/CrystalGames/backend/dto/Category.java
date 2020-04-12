package com.CrystalGames.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity                     // Makes hibernate aware that this is the class that is used to transfer the object to relational database table
public class Category {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)			// Auto generates id number
	private int id;
	private String name;
	private String description;
	
	@Column(name="image_url")			// since the name of this column in DB is different 
	private String imageURL;
	
	@Column(name="is_active")
	private boolean active = true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
	
	

}
