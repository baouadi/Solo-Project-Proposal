package com.project.pizzatime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pizza {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String method;
	    private String size;
	    private String crust;
	    private boolean pepperoni;
	    private boolean mushrooms;
	    private boolean onions;
	    private boolean peppers;
	    private boolean sausage;
	    private boolean olives;
	    @OneToOne(mappedBy="pizza", fetch=FetchType.LAZY)
	    private PizzaOrder pizzaOrder;
	    
	    public Pizza() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getCrust() {
			return crust;
		}

		public void setCrust(String crust) {
			this.crust = crust;
		}

		public boolean isPepperoni() {
			return pepperoni;
		}

		public void setPepperoni(boolean pepperoni) {
			this.pepperoni = pepperoni;
		}

		public boolean isMushrooms() {
			return mushrooms;
		}

		public void setMushrooms(boolean mushrooms) {
			this.mushrooms = mushrooms;
		}

		public boolean isOnions() {
			return onions;
		}

		public void setOnions(boolean onions) {
			this.onions = onions;
		}

		public boolean isPeppers() {
			return peppers;
		}

		public void setPeppers(boolean peppers) {
			this.peppers = peppers;
		}

		public boolean isSausage() {
			return sausage;
		}

		public void setSausage(boolean sausage) {
			this.sausage = sausage;
		}

		public boolean isOlives() {
			return olives;
		}

		public void setOlives(boolean olives) {
			this.olives = olives;
		}
		
		

		public PizzaOrder getPizzaOrder() {
			return pizzaOrder;
		}

		public void setPizzaOrder(PizzaOrder pizzaOrder) {
			this.pizzaOrder = pizzaOrder;
		}

		public String generatePreview(PizzaOrder pizzaOrder) {
		    StringBuilder preview = new StringBuilder();
		    preview.append("Method: ").append(method).append("\n");
		    preview.append("Size: ").append(size).append("\n");
		    preview.append("Crust: ").append(crust).append("\n");
		    preview.append("Quantity: ").append(pizzaOrder.getQuantity()).append("\n"); 
		    preview.append("Toppings: \n");
		    if (pepperoni) {
		        preview.append("- Pepperoni\n");
		    }
		    if (mushrooms) {
		        preview.append("- Mushrooms\n");
		    }
		    if (onions) {
		        preview.append("- Onions\n");
		    }
		    if (peppers) {
		        preview.append("- Peppers\n");
		    }
		    if (sausage) {
		        preview.append("- Sausage\n");
		    }
		    if (olives) {
		        preview.append("- Olives\n");
		    }
		    return preview.toString();
		}

	    
}
