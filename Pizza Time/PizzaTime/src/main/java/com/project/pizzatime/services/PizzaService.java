package com.project.pizzatime.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.pizzatime.models.Pizza;
import com.project.pizzatime.repositories.PizzaRepository;

@Service
public class PizzaService {
	 private final PizzaRepository pizzaRepository;

	    
	    public PizzaService(PizzaRepository pizzaRepository) {
	        this.pizzaRepository = pizzaRepository;
	    }

	    public List<Pizza> getAllPizzas() {
	        return pizzaRepository.findAll();	    }

	    public Pizza getPizzaById(Long id) {
	        return pizzaRepository.findById(id).orElse(null);
	    }

	    public Pizza savePizza(Pizza pizza) {
	        return pizzaRepository.save(pizza);
	    }
	    
	    public void deletePizzaById(long id) {
	        this.pizzaRepository.deleteById(id);
	    }
	}