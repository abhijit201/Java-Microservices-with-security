package com.olx.adverties.dto;

import java.util.Date;

public class Advertise {
private int id;
private String title;
private String category;
private String status;
private double price;
private String description;
private java.util.Date createdDate;
private java.util.Date modifiedDate;
private String postedBy;
private String username;
private int categoryId;
private int statusId;
//private String categoryName;
//private String statusName;

public Advertise() {}

public Advertise(int id, String title, double price, String category, String description, String username,
		java.util.Date createdDate, java.util.Date modifiedDate, String status, String postedBy, int categoryId, int statusId) {
	super();
	this.id = id;
	this.title = title;
	this.price = price;
	this.category = category;
	this.description = description;
	this.username = username;
	this.createdDate = createdDate;
	this.modifiedDate = modifiedDate;
	this.status = status;
	this.postedBy = postedBy;
	this.categoryId = categoryId;
	this.statusId = statusId;
}



public Advertise(int id, String title, String category, String status, double price, String description,
		Date createdDate, Date modifiedDate) {
	super();
	this.id = id;
	this.title = title;
	this.category = category;
	this.status = status;
	this.price = price;
	this.description = description;
	this.createdDate = createdDate;
	this.modifiedDate = modifiedDate;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public java.util.Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(java.util.Date createdDate) {
	this.createdDate = createdDate;
}
public java.util.Date getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(java.util.Date modifiedDate) {
	this.modifiedDate = modifiedDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public String getPostedBy() {
	return postedBy;
}

public void setPostedBy(String postedBy) {
	this.postedBy = postedBy;
}

public int getCategoryId() {
	return categoryId;
}


public int getStatusId() {
	return statusId;
}

public void setStatusId(int statusId) {
	this.statusId = statusId;
}

public void setCategoryId(int i) {
	this.categoryId = i;
}



@Override
public String toString() {
	return "Advertise [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category + ", description="
			+ description + ", username=" + username + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
			+ ", status=" + status + ", postedBy=" + postedBy + ", categoryId=" + categoryId + "]";
}


}