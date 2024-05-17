package com.project.pizzatime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.pizzatime.models.LoginUser;
import com.project.pizzatime.models.User;
import com.project.pizzatime.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String newRegister(Model model, HttpSession session) {
	    if (session.getAttribute("userId") == null) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "register.jsp";
	    }
	    model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
	    return "home.jsp";
	}

	@PostMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	    if (result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "register.jsp"; 
	    }

	    User user = userService.register(newUser, result);

	    if (user == null || result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "register.jsp"; 
	    }

	    session.setAttribute("userId", user.getId());
	    return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "login.jsp";
		} 

		User user = userService.login(newLogin, result);
		if (user == null) {
			result.rejectValue("email", "error.user", "Invalid email or password");
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "redirect:/home";
		}

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/login";
		}

		model.addAttribute("user", userService.findById((Long) session.getAttribute("userId")));
		return "home.jsp";
	}
	
	@PostMapping("/home")
	public String updateUser(Model model,HttpSession session) {

	    if (session.getAttribute("userId") == null) {
	        return "redirect:/login";
	    }
	    return "home.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
