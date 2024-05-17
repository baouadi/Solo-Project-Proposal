package com.project.pizzatime.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PizzaOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;
	private double price;
	private boolean status;
	private boolean favorite;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pizza_id")
    private Pizza pizza;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public PizzaOrder() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	
}
