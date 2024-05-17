package com.project.pizzatime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.pizzatime.models.Pizza;
import com.project.pizzatime.models.PizzaOrder;
import com.project.pizzatime.models.User;
import com.project.pizzatime.repositories.PizzaOrderRepository;
import com.project.pizzatime.services.PizzaOrderService;
import com.project.pizzatime.services.PizzaService;
import com.project.pizzatime.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PizzaController {
	@Autowired
	private UserService userService;
	@Autowired
	private PizzaOrderService pizzaOrderService;
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/order")
	public String showOrderForm(Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("userId");
		PizzaOrder pizzaOrder = pizzaOrderService.findActiveOrder(user_id);
		if (pizzaOrder != null) {
			model.addAttribute("pizza", pizzaOrder.getPizza());

			model.addAttribute("pizzaOrder", pizzaOrder);
			return "confirmOrder.jsp";
		}
		model.addAttribute("pizza", new Pizza());
		return "order.jsp";
	}

	@PostMapping("/order")
	public String processOrderForm(@Valid @ModelAttribute("newPizza") Pizza pizza, Model model, HttpSession session,
			HttpServletRequest request) {
		Long user_id = (Long) session.getAttribute("userId");

		pizzaService.savePizza(pizza);
		User user = userService.findById(user_id);
		PizzaOrder pizzaOrder = new PizzaOrder();
		pizzaOrder.setPizza(pizza);
		pizzaOrder.setStatus(false);
		int qty = Integer.parseInt(request.getParameter("quantity"));
		pizzaOrder.setQuantity(qty);
		pizzaOrder.setPrice(5 * qty);
		pizzaOrder.setUser(user);
		pizzaOrderService.savePizzaOrder(pizzaOrder);

		// session.setAttribute("craftedPizza", pizza);
		// session.setAttribute("craftedPizzaOrder", pizzaOrder);
		model.addAttribute("pizza", pizzaOrder.getPizza());

		model.addAttribute("pizzaOrder", pizzaOrder);

		return "confirmOrder.jsp";
	}

	@PostMapping("/confirmOrder")
	public String confirmOrder(HttpServletRequest request, HttpSession session) {
		Long user_id = (Long) session.getAttribute("userId");
		PizzaOrder pizzaOrder = pizzaOrderService.findActiveOrder(user_id);
		
		System.out.println(pizzaOrderService.findActiveOrder(user_id));
		if (request.getParameter("submit").equals("startOver")) {
			pizzaOrderService.deletePizzaOrderById(pizzaOrder.getId());
			pizzaService.deletePizzaById(pizzaOrder.getPizza().getId());
			return "redirect:/order";
		} else if (request.getParameter("submit").equals("purchase")) {
			pizzaOrder.setStatus(true);
			pizzaOrderService.savePizzaOrder(pizzaOrder);
			return "redirect:/account";
		}
		return "redirect:/";
	}

	@GetMapping("/reorder")
	public String reOrderForm(Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("userId");

		PizzaOrder FavoritePizzaOrder = pizzaOrderService.findFavoriteOrder(user_id);
		PizzaOrder ActivepizzaOrder = pizzaOrderService.findActiveOrder(user_id);
		if(ActivepizzaOrder != null)
		 {pizzaOrderService.deletePizzaOrderById(ActivepizzaOrder.getId());
		 }
		if (FavoritePizzaOrder != null) {
			Pizza pizza = new Pizza();
			pizza.setCrust(FavoritePizzaOrder.getPizza().getCrust());
			pizza.setMethod(FavoritePizzaOrder.getPizza().getMethod());
			pizza.setMushrooms(FavoritePizzaOrder.getPizza().isMushrooms());
			pizza.setOlives(FavoritePizzaOrder.getPizza().isOlives());
			pizza.setOnions(FavoritePizzaOrder.getPizza().isOnions());
			pizza.setPepperoni(FavoritePizzaOrder.getPizza().isPepperoni());
			pizza.setPeppers(FavoritePizzaOrder.getPizza().isPeppers());
			pizza.setSausage(FavoritePizzaOrder.getPizza().isSausage());
			pizza.setSize(FavoritePizzaOrder.getPizza().getSize());
			pizzaService.savePizza(pizza);
			PizzaOrder pizzaOrder = new PizzaOrder();
			pizzaOrder.setUser(FavoritePizzaOrder.getUser());
			pizzaOrder.setPrice(FavoritePizzaOrder.getPrice());
			pizzaOrder.setQuantity(FavoritePizzaOrder.getQuantity());
			pizzaOrder.setPizza(pizza);
			pizzaOrder.setStatus(false);
			pizzaOrder.setFavorite(true);
			pizzaOrderService.savePizzaOrder(pizzaOrder);
			model.addAttribute("pizza", pizzaOrder.getPizza());

			model.addAttribute("pizzaOrder", pizzaOrder);
			return "confirmOrder.jsp";
		}
		model.addAttribute("pizza", new Pizza());
		return "order.jsp";
	}

	@PostMapping("/updateFavorite/{id}")
	public String confirmFavorite(HttpServletRequest request, HttpSession session, @PathVariable Long id) {
		// Long user_id = (Long) session.getAttribute("userId");
		PizzaOrder pizzaOrder = pizzaOrderService.findById(id);
		pizzaOrder.setFavorite(!pizzaOrder.isFavorite());
		pizzaOrderService.savePizzaOrder(pizzaOrder);
		return "redirect:/account";

	}

}
