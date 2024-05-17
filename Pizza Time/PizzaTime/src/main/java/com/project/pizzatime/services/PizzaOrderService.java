package com.project.pizzatime.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.pizzatime.models.PizzaOrder;
import com.project.pizzatime.repositories.PizzaOrderRepository;


@Service
public class PizzaOrderService {
	private final PizzaOrderRepository pizzaOrderRepository;
	  public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
	        this.pizzaOrderRepository = pizzaOrderRepository;
	    }
	public PizzaOrderRepository getPizzaOrderRepository() {
		return pizzaOrderRepository;
	}
	
	 public PizzaOrder savePizzaOrder(PizzaOrder pizzaOrder) {
	        return pizzaOrderRepository.save(pizzaOrder);
	    }
	 
	 public PizzaOrder findById(Long id) {
	        return pizzaOrderRepository.findById(id).orElse(null);
	    }
	 
	 public void deletePizzaOrderById(long id) {
	        this.pizzaOrderRepository.deleteById(id);
	    }
	 public void deletePizzaOrderByStatus(boolean status) {
	        this.pizzaOrderRepository.deletePizzaOrderByStatus(status);
	    }
	 public PizzaOrder findByUserId(Long idUser) { 
	        return pizzaOrderRepository.findByUserId(idUser).orElse(null);
	    }
	 public PizzaOrder findActiveOrder(Long idUser) { 
	        return pizzaOrderRepository.findActiveOrder(idUser).orElse(null);
	    }
	public List<PizzaOrder> findByUserIdAndStatus(Long idUser) {
		
		return pizzaOrderRepository.findByUserIdAndStatus(idUser);
	}
	 public PizzaOrder findFavoriteOrder(Long idUser) { 
	        return pizzaOrderRepository.findFavoriteOrder(idUser).orElse(null);
	    }
	
}
