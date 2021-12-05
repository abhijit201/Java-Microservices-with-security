package com.olx.adverties.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name ="ADVERTISES")
public class AdvertiseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;
	@Column(name ="category")
	private int category;
	@Column(name ="status")
	private int status;
	@Column(name ="price")
	private Double price;
	@Column(name ="description")
	private String description;
//	@Column(name ="photo")
//	private Blob photo;
	@Column(nullable = false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date created_date = new Date();
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modified_date = new Date();
	@Column(name ="posted_by")
	private String posted_by;
	@Column(name ="active")
	private Boolean active;
	@Column(name ="username")
	private String username;
	
	public AdvertiseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AdvertiseEntity(int id, String title, int category, int status, Double price,
			String description, /* Blob photo, */
			Date created_date, Date modified_date, String posted_by, Boolean active, String username) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
//		this.photo = photo;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.posted_by = posted_by;
		this.active = active;
		this.username = username;
	}
	
	



	public AdvertiseEntity(String title, int category, int status, Double price, String description) {
		super();
		this.title = title;
		this.category = category;
		this.status = status;
		this.price = price;
		this.description = description;
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
//	public Blob getPhoto() {
//		return photo;
//	}
//	public void setPhoto(Blob photo) {
//		this.photo = photo;
//	}
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
		return "AdvertiesEntity [id=" + id + ", title=" + title + ", category=" + category + ", status=" + status
				+ ", price=" + price + ", description="
				+ description /* + ", photo=" + photo */ + ", created_date="
				+ created_date + ", modified_date=" + modified_date + ", posted_by=" + posted_by + ", active=" + active
				+ ", username=" + username + "]";
	}
}
