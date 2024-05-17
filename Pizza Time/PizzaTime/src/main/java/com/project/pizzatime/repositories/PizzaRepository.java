package com.project.pizzatime.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.pizzatime.models.Pizza;


@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
	List<Pizza> findAll();
}
