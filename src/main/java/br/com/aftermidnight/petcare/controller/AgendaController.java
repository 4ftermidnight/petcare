package br.com.aftermidnight.petcare.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/agenda")
public class AgendaController {
	
	@RequestMapping(value = "/datasdisponiveis", 
	method = RequestMethod.GET,  
	produces =  { 
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE 
			})
	public @ResponseBody List<Date> datasDisponiveis(){
		List<Date> datasDisponiveis = new ArrayList<>();
		
		datasDisponiveis.add(new Date());
		
		return datasDisponiveis;
	}

}
