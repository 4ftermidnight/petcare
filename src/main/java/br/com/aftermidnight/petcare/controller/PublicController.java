package br.com.aftermidnight.petcare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {
	

	@GetMapping("/")
	public ModelAndView home(Authentication authentication) {

//		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("principal:"+principal);
		System.out.println("authentication:"+authentication);
	
		
		ModelAndView mv = new ModelAndView("public/Home");

		return mv;
	}
}