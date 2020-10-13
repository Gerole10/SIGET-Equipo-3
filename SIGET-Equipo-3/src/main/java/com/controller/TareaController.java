package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Tarea;
import com.service.Tareaservice;

@Controller
public class TareaController {
	
	@Autowired
	private Tareaservice serv;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", serv.getAllTareas());
		return "index";
	}
	
	
	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable/*("id")*/ String id , Model model) {
		if(serv.findTareaById(id).isPresent()) {
			model.addAttribute("tarea", serv.findTareaById(id).get());
			//System.out.println(id);
		}else {
			model.addAttribute("tarea", new Tarea());
		}
		return "update";
	}
	
	@PostMapping("/update")
	public String update(Tarea tarea, Model model) {
		serv.updateTarea(tarea);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		serv.deleteTareaById(id);
		
		return "redirect:/";
	}
	
	

}
