package com.project.pizzatime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.pizzatime.models.PizzaOrder;
import com.project.pizzatime.models.User;
import com.project.pizzatime.services.PizzaOrderService;
import com.project.pizzatime.services.PizzaService;
import com.project.pizzatime.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
	private PizzaOrderService pizzaOrderService;
	@Autowired
	private PizzaService pizzaService;
	
    
    
    @GetMapping("/account")
    public String openEditAccount(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        User user = userService.findById(userId);
        List<PizzaOrder> pizzaOrders =  pizzaOrderService.findByUserIdAndStatus(userId);
        model.addAttribute("userUpdate", user); 
        model.addAttribute("pizzaOrders", pizzaOrders); 
        return "account.jsp"; 
    }


    @PostMapping("/account")
    public String editAccount(@Valid @ModelAttribute("userUpdate") User userUpdate, BindingResult result, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        if (result.hasErrors()) {
            return "account.jsp";
        }

        Long id = userUpdate.getId();

        userService.updateUser(userId, userUpdate);

        return "account.jsp";
    }


}

	

