package com.project.pizzatime.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;

@NotEmpty(message="First name is required!")
@Size(min=3, max=30, message="First name must be between 3 and 30 caracters")
private String firstName;

@NotEmpty(message="Last name is required!")
@Size(min=3, max=30, message="Last name must be between 3 and 30 caracters")
private String lastName;

@NotEmpty(message="Email is required!")
@Email(message="Please enter a valid email!")
private String email;

@NotEmpty(message="Address is required!")
@Size(min=3, max=30, message="Address must be between 3 and 30 caracters")
private String address;

@NotEmpty(message="City is required!")
@Size(min=3, max=20, message="City must be between 3 and 20 caracters")
private String city;

private String state;

@NotEmpty(message="Password is required!")
@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
private String password;

@Transient
@NotEmpty(message="Confirm Password is required!")
@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
private String confirm;

@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
private List<PizzaOrder> pizzaOrder;

public User() {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getConfirm() {
	return confirm;
}

public void setConfirm(String confirm) {
	this.confirm = confirm;
}

public List<PizzaOrder> getPizzaOrder() {
	return pizzaOrder;
}

public void setPizzaOrder(List<PizzaOrder> pizzaOrder) {
	this.pizzaOrder = pizzaOrder;
}

	
}
