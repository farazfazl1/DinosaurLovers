package com.codingdojo.DinosaurLovers.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.DinosaurLovers.models.LoginUser;
import com.codingdojo.DinosaurLovers.models.User;
import com.codingdojo.DinosaurLovers.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

//==========================================================================================
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		
		return "index.jsp";
	}
	
//==========================================================================================
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session ) {
		
		User helloUser = service.createUser(newUser, result);
		if(result.hasErrors()) {
			
			model.addAttribute("loginUser", newUser);
			return "index.jsp";
		}
		else {
			session.setAttribute("session_user_id", helloUser.getId());
			return "redirect:/dashboard";
			
			
		}
	}
//==========================================================================================
		@PostMapping("/login")
		public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session,RedirectAttributes errors) {
			User welcomeBackUser = this.service.login(loginUser, result);
			
			if(result.hasErrors() || welcomeBackUser == null) {
				errors.addFlashAttribute("error", "Invalid Email/password");
				//model.addAttribute("newUser", new LoginUser());
				return "redirect:/";
			}
			else {
				session.setAttribute("session_user_id", welcomeBackUser.getId());
				return "redirect:/dashboard";
			}
		}	
//==========================================================================================
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
////==========================================================================================
}
