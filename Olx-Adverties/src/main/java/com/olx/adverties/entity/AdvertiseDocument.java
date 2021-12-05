package com.olx.adverties.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="advertise")
public class AdvertiseDocument {

	
	@Id
	private int id;
	
	private String title;
	private int category;
	private int status;
	private Double price;
	private String description;
	private Date created_date;
	private Date modified_date;
	private String posted_by;
	private Boolean active;
	private String username;
	
	
	
	public AdvertiseDocument() {
		// TODO Auto-generated constructor stub
	}
	public AdvertiseDocument(int id, String title, int category, int status, Double price, String description,
			Date created_date, Date modified_date, String posted_by, Boolean active, String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.posted_by = posted_by;
		this.active = active;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "AdvertiseDocument [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status
				+ ", price=" + price + ", description=" + description + ", created_date=" + created_date
				+ ", modified_date=" + modified_date + ", posted_by=" + posted_by + ", active=" + active + ", username="
				+ username + "]";
	}
	
	
	
}
