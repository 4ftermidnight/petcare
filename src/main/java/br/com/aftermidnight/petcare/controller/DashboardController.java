package br.com.aftermidnight.petcare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aftermidnight.petcare.repository.Clientes;


@Controller
public class DashboardController {
	
	@Autowired
	private Clientes clientes;
	

	@GetMapping("/Dashboard")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("Dashboard");
		
		return mv;
	}
	
}