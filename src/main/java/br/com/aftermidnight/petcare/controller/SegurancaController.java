package br.com.aftermidnight.petcare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SegurancaController {

	@GetMapping("/login")
	public String login(Authentication authentication){ //@AuthenticationPrincipal injeta o usuário logado
		if (authentication != null && authentication.isAuthenticated()){
			return "redirect:/Home";
		}
		return "Login";
	}
	

}
