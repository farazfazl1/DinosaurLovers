package com.codingdojo.DinosaurLovers.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DinosaurLovers.models.Dinosaur;
import com.codingdojo.DinosaurLovers.services.DinosaurService;
import com.codingdojo.DinosaurLovers.services.UserService;

@Controller
public class DinosaurController {
	
//======================================================================
	@Autowired
	private UserService service;
	
	@Autowired
	private DinosaurService dinoService;
//======================================================================

	
	
//======================================================================
	//DASHBOARD
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("session_user_id") == null) {
			return "redirect:/logout";
		}
		Long id = (Long) session.getAttribute("session_user_id");
		model.addAttribute("user", service.findUser(id));
		model.addAttribute("all_dinos", dinoService.allDinosaurs());
		return "dashboard.jsp";
	}
//======================================================================

	
	
//======================================================================
	//EDIT DINO GETMAP
	@GetMapping("/dino/edit/{id}")
	public String editDinoPage(@PathVariable("id") Long id, Model model,
			HttpSession session) {
		if(session.getAttribute("session_user_id") == null) {
			return "redirect:/logout";
		}
		else {
			Dinosaur dino = dinoService.findDinoById(id);
			model.addAttribute("dino", dino);
			model.addAttribute("user", service.findUser((Long)session.getAttribute("session_user_id")));
			return "edit.jsp";
		}
	}
//======================================================================
	
	
	
//======================================================================
	//EDIT DINO PUTMAP
	@PutMapping("/dino/edit/{id}")
	public String letsEdit(@Valid @ModelAttribute("dino") Dinosaur dino,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			dinoService.updateDino(dino);
			return "redirect:/dashboard";
		}
	}
//======================================================================

	
	
//======================================================================
	//ADD DINO GETMAP
	@GetMapping("/add_dino")
	public String addDino(HttpSession session, Model model, @ModelAttribute("dino") Dinosaur dino) {
		if(session.getAttribute("session_user_id") == null) {
    		return "redirect:/logout";
    	}
		else {
			model.addAttribute("user", service.findUser((Long)session.getAttribute("session_user_id")));
			return "add.jsp";
		}
	}
//======================================================================

	
	
//======================================================================
	//ADD DINO POSTMAP
	@PostMapping("/add_dino")
	public String createDino(@Valid @ModelAttribute("dino") Dinosaur dino, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		else {
			dinoService.createDino(dino);
			return "redirect:/dashboard";
		}
	}
//======================================================================

	
	
//======================================================================
	//DELETE DINO
	@RequestMapping(value="/dino/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		dinoService.deleteDino(id);
		return "redirect:/dashboard";
	}
//======================================================================



//======================================================================
	//SHOW A DINO
	@GetMapping("/dino/{id}")
	public String showDino(Model model, @PathVariable("id") Long id,
			HttpSession session) {
		if(session.getAttribute("session_user_id") == null) {
    		return "redirect:/logout";
    	}
		else {
			Dinosaur dino = dinoService.findDinoById(id);
			model.addAttribute("dino", dino);
			model.addAttribute("user", service.findUser((Long)session.getAttribute("session_user_id")));
			return "show.jsp";
		}
	}
//======================================================================

	
}